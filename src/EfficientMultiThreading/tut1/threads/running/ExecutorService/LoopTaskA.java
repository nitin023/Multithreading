package EfficientMultiThreading.tut1.threads.running.ExecutorService;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {

    private static int count = 0;
    private int id;

    @Override
    public void run() {
        System.out.println("##### <TASK-" + id + "> STARTING #####" + Thread.currentThread().getName());
        for (int i = 10; i >= 0; i--) {
            System.out.println("< " + id + " >" + "TICK TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep((int) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("##### <TASK-" + id + "> COMPLETED #####" + Thread.currentThread().getName());
    }

    public LoopTaskA() {
        this.id = ++count;
    }
}
