package EfficientMultiThreading.tut1.threads.running.NormalThread;

import java.util.concurrent.TimeUnit;

public class FifthTechnique {

    public static void main(String[] args) {
        System.out.println("Main thread starts here ........");
        Thread t = new Thread(() -> {
            for (int i = 10; i >= 0; i--) {
                System.out.println("TICK TICK - " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println("Main thread ends here ........");
    }
}

