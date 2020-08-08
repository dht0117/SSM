package Lambda;

public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("多线程执行");
    }
}
