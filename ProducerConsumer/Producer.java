public class Producer extends Thread {
	
	private Letters pool;

	private final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public Producer(Letters thePool, String name) {
		super(name);
		this.pool = thePool;
	}

	public void run() {
		char ch;
		// Add 10 letters to the pool
		for (int i = 0; i < 10; i++) {
			ch = ALPHABET.charAt((int) (Math.random() * 26));
			pool.addLetter(ch);
			// print a record of our addition
			System.out.println( Thread.currentThread().getName() + "\tAdded " + ch + " to the pool.");
			// wait before we add the next letter
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}

}
