package EfficientMultiThreading.tut1.threads.running.NormalThread;

public interface ResultListener<T> {

    void notifyResult(T result);
}
