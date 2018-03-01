import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LettersImplQueue implements Letters {
	
	private static final int BUFFER_CAPACITY = 5;
	private BlockingQueue<Character> pool = new LinkedBlockingQueue<Character>(BUFFER_CAPACITY);
	
	public void addLetter(char c) {
		try {
			pool.put(c);
		} catch ( InterruptedException e ) {
			Thread.currentThread().interrupt();
		}
	}
	
	public char takeLetter() {
		Character c = null;
		
		try {
			c = pool.take();
		} catch ( InterruptedException e ) {
			Thread.currentThread().interrupt();
		}
		return c;
	}
}
