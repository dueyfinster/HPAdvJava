import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class LettersImplLockobj implements Letters {
	
	private final static int BUFFER_CAPACITY = 5;
	private char[] buffer = new char[BUFFER_CAPACITY];
	private int next = 0;
	private final Lock bufferLock = new ReentrantLock();
	private final Condition notFull = bufferLock.newCondition();
	private final Condition notEmpty = bufferLock.newCondition();

	public void addLetter(char c) {
		bufferLock.lock();		
		try {
			// wait until pool has room for new letter
			while ( next == BUFFER_CAPACITY ) {
				try {
					notFull.await();
				} catch ( InterruptedException ignore ) {  }
			}
			// add the letter to the next available spot
			buffer[next++] = c;
			notEmpty.signalAll();
		} finally {
			bufferLock.unlock();
		}
	}

	public char takeLetter() {
		bufferLock.lock();		
		try {
			// wait until the pool becomes non-empty
			while ( next == 0 ) {
				try {
					notEmpty.await();
				} catch ( InterruptedException ignore ) {  }
			}
		    // decrement the count, since we're going to remove one letter
		    next--;
		    return(buffer[next]);
		} finally {
			notFull.signalAll();
			bufferLock.unlock();
		}
	}

}
