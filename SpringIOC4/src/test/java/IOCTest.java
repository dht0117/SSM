import com.atguigu.Service.BookService;
import com.atguigu.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test1(){
        BookService bookService = ioc.getBean(BookService.class);
        UserService userService = ioc.getBean(UserService.class);

        bookService.save();
        userService.save();
        //带泛型的父类com.atguigu.Service.BaseService<com.atguigu.Bean.Book>
        //Spring中可以使用带泛型的父类类型来确定这个子类的类型
        System.out.println(bookService.getClass().getGenericSuperclass());

        //ioc是一个容器，帮我们管理所有的组件；
        //1.依赖注入：@Autowired，自动赋值
        //2.某个组件要使用Spring提供的更多（IOC、AOP），必需加入到容器中

        /**
         * 体会：
         * 1.容器启动，创建所有单实例bean
         * 2.autowired自动装配的时候，是从容器中找这些符合要求的bean
         * 3.ioc。getBean（）也是从容器中找到这个bean
         * 4.容器中包含了所有bean
         * 5.调试spring源码，容器其实就是一个map
         * 6.map保存好所有创建的bean，并提供外界的获取功能
         */
    }
}
