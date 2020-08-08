import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test1 {
//    public static void main(String[] args) {
//       ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Helloworld helloworld =(Helloworld) ct.getBean("helloworld");
//        helloworld.hello();
//    }
    @Test
    public void fun1(){
        ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
        Helloworld helloworld =(Helloworld) ct.getBean("helloworld");
        helloworld.hello();
    }
}
