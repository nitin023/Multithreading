package EfficientMultiThreading.tut1.threads.running.ExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ValueReturningTaskD implements Callable<TaskResult<String,Integer>> {
    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;

    public ValueReturningTaskD(int a, int b, long sleepTime) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ValueReturningFromTaskC-" + instanceNumber;
    }

    @Override
    public TaskResult<String,Integer> call() throws Exception{
        String currentThreadTime = Thread.currentThread().getName();
        System.out.println("#### [" + currentThreadTime + "] <" + taskId + "> STARTING ####");
        TimeUnit.MILLISECONDS.sleep(sleepTime);
        sum = a + b;
        System.out.println("**** [" + currentThreadTime + "] <" + taskId + "> CALCULATION COMPLETED ****");
        return new TaskResult<>(taskId,sum);
    }
}
