import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class LettersImplBasic implements Letters {
	
	private final static int BUFFER_CAPACITY = 5;
	private char[] buffer = new char[BUFFER_CAPACITY];
	private int next = 0;
	private boolean isFull = false;
	private boolean isEmpty = true;


	public synchronized void addLetter(char c) {
		// wait until pool has room for new letter
	      while (isFull == true) {
	         try {
	            wait();
	         } catch ( InterruptedException e ) {}
	      }
	      // add the letter to the next available spot
	      buffer[next++] = c;
	      // are we full?
	      if (next == BUFFER_CAPACITY) {
	         isFull = true;
	      }
	      isEmpty = false;
	      notify();
	}

	public synchronized char takeLetter() {
		// wait until the pool becomes non-empty
	      while (isEmpty == true) {
	         try {
	            wait(); // we'll exit this when isEmpty turns false
	         } catch (InterruptedException e) {}
	      }
	      // decrement the count, since we're going to remove one letter
	      next--;
	      // Was this the last letter?
	      if (next == 0){
	         isEmpty = true;
	      }
	      // we know the pool can't be full, because we took a letter
	      isFull = false;
	      notify();
	      return(buffer[next]); // return char to Consumer thread
	}

}
