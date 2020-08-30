package EfficientMultiThreading.tut1.threads.running.ExecutorService;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

    private static int count = 0 ;
    private static String NAME = "PoolWorker-";
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r,NAME + ++count);
        return thread;
    }
}
