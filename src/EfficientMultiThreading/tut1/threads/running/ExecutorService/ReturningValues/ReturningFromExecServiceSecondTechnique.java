package EfficientMultiThreading.tut1.threads.running.ExecutorService.ReturningValues;

import EfficientMultiThreading.tut1.threads.running.ExecutorService.LoopTaskA;
import EfficientMultiThreading.tut1.threads.running.ExecutorService.NamedThreadFactory;
import EfficientMultiThreading.tut1.threads.running.ExecutorService.TaskResult;
import EfficientMultiThreading.tut1.threads.running.ExecutorService.ValueReturningTaskD;

import java.util.concurrent.*;

public class ReturningFromExecServiceSecondTechnique {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[ " + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

        CompletionService<TaskResult<String, Integer>> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(new ValueReturningTaskD(2, 5, 1000));
        completionService.submit(new ValueReturningTaskD(12, 15, 2000));
        completionService.submit(new ValueReturningTaskD(21, 5, 500));
        completionService.submit(new LoopTaskA(), new TaskResult<>("LoopTask1", 999));
        executorService.shutdown();

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println("Result = " + completionService.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[ " + currentThreadName + "] Main thread ends here...");
    }
}
