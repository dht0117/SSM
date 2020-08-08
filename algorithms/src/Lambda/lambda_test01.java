package Lambda;

/**
 * 使用匿名内部类
 */
public class lambda_test01 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类执行！");
            }
        }).start();
    }
}
