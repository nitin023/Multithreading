package EfficientMultiThreading.tut1.threads.running.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThreads {
    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(" [" + currentThreadName + "] Main thread starts here ....");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        for (int i = 0; i < 10; i++) {
            executorService.execute(new LoopTaskC());
        }
        executorService.shutdown();
        System.out.println("[" + currentThreadName + "] Main thread ends here ....");
    }
}
