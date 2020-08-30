package EfficientMultiThreading.tut1.threads.running.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadExecutor {
    public static void main(String[] args) {
        System.out.println("Main thread starts here...");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new LoopTaskA());
        }
        executorService.shutdown();
        System.out.println("Main thread ends here...");
    }
}
