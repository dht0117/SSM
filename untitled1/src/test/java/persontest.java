import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;


public class persontest {
//    private ApplicationContext ioc=new ClassPathXmlApplicationContext("ioc.xml");
     ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext2.xml");

    @Test
    public void fun1(){
        ApplicationContext ap=new ClassPathXmlApplicationContext("ioc.xml");
        Person p = (Person)ap.getBean("person1");
        System.out.println(p);
    }
    /**
     * 实验二：根据bean类型从IOC容器中获取bean的实例
     */
    @Test
    public void fun2(){
        //第一种方法获取只能获取容器中只有单个bean的情况
//        Person bean = ioc.getBean(Person.class);
//        System.out.println(bean);
        Person person2 = ioc.getBean("person2", Person.class);
        System.out.println(person2);
        Person person3 = ioc.getBean("person3", Person.class);
        System.out.println(person3);
    }

    @Test
    public void fun3() throws SQLException {
        //从容器中拿连接池
        DataSource bean = (DataSource) ioc.getBean("dataSource");
        System.out.println(bean.getConnection());
    }
}
