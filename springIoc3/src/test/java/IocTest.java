import com.atguigu.Servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IocTest {
    /**
     * 使用注解加入到容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的
     * 1.组件的id默认就是组件的类名首字母小写
     * 2.组件的作用域是单例的(默认)也可以修改
     * @Scope（vlaue=“prototype”）
     */
//    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    ApplicationContext ioc=null;
    @Autowired
    BookServlet bookServlet;
    @Test
    public void test3(){
        System.out.println(bookServlet);
    }

    @Test
    public void test2(){
//        BookServlet bookServlet = ioc.getBean(BookServlet.class);
//        bookServlet.doGet();
    }
//    @Test
//    public void test(){
////        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object bean = ioc.getBean("bookDao");
//        Object bean2 = ioc.getBean("bookDao");
//        System.out.println(bean==bean2);
//    }
}
