import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class CVPingPong
{
    private static final int REPETITIONS = 1 * 1000 * 1000;

    private static final Lock sendLock = new ReentrantLock();
    private static final Condition sendCondition = sendLock.newCondition();

    private static final Lock echoLock = new ReentrantLock();
    private static final Condition echoCondition = echoLock.newCondition();

    private static long sendValue = -1;
    private static long echoValue = -1;

    public static void main(final String[] args)
        throws Exception
    {
        final Thread sendThread = new Thread(new SendRunner());
        final Thread echoThread = new Thread(new EchoRunner());
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
                sendLock.lock();
                try
                {
                    sendValue = i;
                    sendCondition.signal();
                }
                finally
                {
                    sendLock.unlock();
                }

                echoLock.lock();
                try
                {
                    while (echoValue != i)
                    {
                        echoCondition.await();
                    }
                }
                catch (final InterruptedException ex)
                {
                    break;
                }
                finally
                {
                    echoLock.unlock();
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
                sendLock.lock();
                try
                {
                    while (sendValue != i)
                    {
                        sendCondition.await();
                    }
                }
                catch (final InterruptedException ex)
                {
                    break;
                }
                finally
                {
                    sendLock.unlock();
                }

                echoLock.lock();
                try
                {
                    echoValue = i;
                    echoCondition.signal();
                }
                finally
                {
                    echoLock.unlock();
                }
            }
        }
    }
}
