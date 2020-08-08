import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TXTest {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test1(){
        BookService bean = ioc.getBean(BookService.class);
        bean.checkout("Tom","ISBN-001");
        System.out.println("1111");
    }
}
