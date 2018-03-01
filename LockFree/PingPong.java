import static java.lang.System.out;

public class PingPong
{
    private static final long REPETITIONS = 1L * 1000L * 1000L;

    private static volatile long sendValue = -1;
    private static volatile long echoValue = -1;

    public static void main(final String[] args)
        throws Exception
    {
        final Thread echoThread = new Thread(new EchoRunner());
        final Thread sendThread = new Thread(new SendRunner());
        echoThread.start();
        sendThread.start();

        final long start = System.nanoTime();

        echoThread.join();

        final long duration = System.nanoTime() - start;

        out.printf("duration %,d (ns)\n", duration);
        out.printf("%,d ns/op\n", duration / (REPETITIONS * 2L));
        out.printf("%,d ops/s\n", (REPETITIONS * 2L * 1000L * 1000L * 1000L) / duration);
        out.println("sendValue = " + sendValue + ", echoValue = " + echoValue);
    }

    public static class SendRunner implements Runnable
    {
        public void run()
        {
            for (long i = 0; i < REPETITIONS; i++)
            {
                sendValue = i;

                while (echoValue != i)
                {
                    // busy spin
                }
            }
        }
    }

    public static class EchoRunner implements Runnable
    {
        public void run()
        {
            for (long i = 0; i < REPETITIONS; i++)
            {
                while (sendValue != i)
                {
                    // busy spin
                }

                echoValue = i;
            }
        }
    }
}
