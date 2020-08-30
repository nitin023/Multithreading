package EfficientMultiThreading.tut1.threads.running.ExecutorService;

public class NamingThreadConvention {
    public static void main(String[] args) {

        String currentThreadName = Thread.currentThread().getName();
        System.out.println(" [" + currentThreadName + "] Main thread starts here ...." );
        new Thread(new LoopTaskB(),"Worker-1").start();
        Thread thread = new Thread(new LoopTaskB(),"Worker-2");
        thread.start();
        System.out.println("[" + currentThreadName + "] Main thread ends here ....");
    }
}
