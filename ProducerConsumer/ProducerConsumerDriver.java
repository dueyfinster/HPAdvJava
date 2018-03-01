public class ProducerConsumerDriver {
	
	private static Letters letterPool = new LettersImplSem();

	public static void main(String[] args) {

		new Producer(letterPool, "Producer1" ).start();
		new Producer(letterPool, "Producer2" ).start();
		
		new Consumer(letterPool, "Consumer1" ).start();
		new Consumer(letterPool, "Consumer2" ).start();
	}

}
