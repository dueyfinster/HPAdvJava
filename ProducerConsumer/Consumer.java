
public class Consumer extends Thread {
	private Letters pool;

	public Consumer(Letters thePool, String name) {
		this.setName(name);
		this.pool = thePool;
	}

	public void run() {
		char ch;
		// Take 10 letters from the pool
		for (int i = 0; i < 10; i++) {
			// take one letter
			ch = pool.takeLetter();
			// print out the letter that we retrieved
			System.out.println(Thread.currentThread().getName() + "\tTook a letter : " + ch);
			// wait before we grab the next letter
			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
			}
		}
	}

}
