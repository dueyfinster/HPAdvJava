import java.util.concurrent.Semaphore;

public class LettersImplSem implements Letters {
	private static final int BUFFER_CAPACITY = 5;
	private char [] buffer = new char[BUFFER_CAPACITY];
	private int next = 0;
	private final Semaphore letters = new Semaphore(0);
	private final Semaphore spaces = new Semaphore(BUFFER_CAPACITY);
	
	public void addLetter(char c) {
		try {
			spaces.acquire();
		} catch ( InterruptedException ignore ) { }
		synchronized ( this ) {
			buffer[next++] = c;
		}
		letters.release();
		System.out.println("Pool: " + new String(buffer));
	}

	public char takeLetter() {
		char charToReturn;
		try {
			letters.acquire();
		} catch ( InterruptedException ignore ) { }
		synchronized ( this ) {
			charToReturn = buffer[--next];
			buffer[next] = ' ';
		}
		spaces.release();
		System.out.println("Pool: " + new String(buffer));
		return charToReturn;
	}

}
