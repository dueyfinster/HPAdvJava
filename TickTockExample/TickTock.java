public class TickTock implements Runnable {
   private String word; 
   private int delay;
   public TickTock ( String w, int d ) 
   { 
     word = w;
     delay = d;
   }
   public void run() 
   { 
     try {
       while ( !Thread.interrupted() ) {
				 System.out.print(word + " ");
         Thread.sleep(delay);
       }
     } catch ( InterruptedException ie ) {
       Thread.currentThread().interrupt();  // Causes thread to terminate
     }
   }
   public static void main(String[] args) {
      Thread t1 = new Thread( new TickTock("tick", 50) );
      Thread t2 = new Thread( new TickTock("tock", 100) );
      t1.start();
      t2.start();
   }
}

