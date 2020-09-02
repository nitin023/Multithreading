package EfficientMultiThreading.tut1.threads.running.NormalThread;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable{
    private int a;
    private int b;
    private long sleepTime;
    private int sum;

    private static int count = 0;
    private int instanceNumber;
    private String taskId;
    private ResultListener<Integer> resultListener;

    public ValueReturningTaskB(int a, int b, long sleepTime,ResultListener<Integer> resultListener) {
        this.a = a;
        this.b = b;
        this.sleepTime = sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ValueReturningFromTaskB-" + instanceNumber;
        this.resultListener = resultListener;
    }

    @Override
    public void run() {
        String currentThreadTime = Thread.currentThread().getName();
        System.out.println("#### [" + currentThreadTime + "] <" + taskId + "> STARTING ####");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = a + b;
        System.out.println("**** [" + currentThreadTime + "] <" + taskId + "> CALCULATION COMPLETED ****");
        resultListener.notifyResult(sum);
    }


}
