package EfficientMultiThreading.tut1.threads.running.NormalThread;

public class SumObserver implements ResultListener<Integer> {

    private String taskId;

    @Override
    public void notifyResult(Integer result) {
        System.out.println("Result for " + taskId + " = " + result);
    }

    public SumObserver(String taskId) {
        this.taskId = taskId;
    }
}
