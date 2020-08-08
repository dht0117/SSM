package Lambda;

/**
 * 使用实类
 */
public class Test {
    public static void main(String[] args) {
        Runnable r=new RunnableImpl();
        Thread t1=new Thread(r);
        t1.start();
        String s="abnfbnf";
        System.out.println(s.length());
        char s1 = s.charAt(0);
        System.out.println(s1);

    }

}
