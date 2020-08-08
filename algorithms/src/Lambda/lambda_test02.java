package Lambda;

/**
 * 使用lambda表达式
 */
public class lambda_test02 {
    public static void main(String[] args) {
        /**
         * 前面一对小括号代表run（）方法的参数，这里代表不需要条件;无参数就留空，有参数用逗号分隔
         * 中间的箭头代表将参数传递给后边的代码；
         * 后边的输出语句代表业务的逻辑代码
         */
        new Thread(()-> System.out.println("lambda表达式执行！")).start();
    }
}
