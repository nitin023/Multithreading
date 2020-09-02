package EfficientMultiThreading.tut1.threads.running.NormalThread;

import java.util.concurrent.TimeUnit;

public class FirstTechnique {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ........");
        new FirstTask();
        new FirstTask();
        System.out.println("Main thread ends here ........");
    }
}

class FirstTask extends Thread {

    private static int count = 0;
    private int id;

    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println("< " + id + " >" + "TICK TICK - " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public FirstTask() {
        this.id = ++count;
        this.start();
    }
}