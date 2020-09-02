package EfficientMultiThreading.tut1.threads.running.ExecutorService.ReturningValues;

import EfficientMultiThreading.tut1.threads.running.ExecutorService.LoopTaskA;
import EfficientMultiThreading.tut1.threads.running.ExecutorService.NamedThreadFactory;
import EfficientMultiThreading.tut1.threads.running.ExecutorService.ValueReturningTaskC;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesFromExecutorsFirstTechnique {

    public static void main(String[] args) {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("[ " + currentThreadName + "] Main thread starts here...");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
        Future<Integer> result1 = executorService.submit(new ValueReturningTaskC(2,5,1000));
        Future<Integer> result2 = executorService.submit(new ValueReturningTaskC(12,15,2000));
        Future<Integer> result3 = executorService.submit(new ValueReturningTaskC(21,5,500));
        Future<?> result4 = executorService.submit(new LoopTaskA());
        Future<Double> result5  = executorService.submit(new LoopTaskA(),999.98);
        executorService.shutdown();

        try {
            System.out.println("Result-1 = " + result1.get());
            System.out.println("Result-2 = " + result2.get());
            System.out.println("Result-3 = " + result3.get());
            System.out.println("Result-4 = " + result4.get());
            System.out.println("Result-5 = " + result5.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("[ " + currentThreadName + "] Main thread ends here...");
    }
}
