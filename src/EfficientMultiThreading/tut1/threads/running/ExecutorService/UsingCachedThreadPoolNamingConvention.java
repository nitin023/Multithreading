package EfficientMultiThreading.tut1.threads.running.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingCachedThreadPoolNamingConvention {
    public static void main(String[] args) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(" [" + currentThreadName + "] Main thread starts here ....");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        for (int i = 0; i < 3; i++) {
            executorService.execute(new LoopTaskC());
        }

        TimeUnit.SECONDS.sleep(5);

        System.out.println("Submitting more tasks now....");


        for (int i = 0; i < 3; i++) {
            executorService.execute(new LoopTaskC());
        }

        executorService.shutdown();
        System.out.println("[" + currentThreadName + "] Main thread ends here ....");
    }
}
