import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TXTest {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    @Test
    public void test1() throws SQLException {
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    @Test
    public void test2() throws SQLException {
        System.out.println(jdbcTemplate);

    }
    @Test
    public void test3(){
        String sql="UPDATE employee SET salary=? WHERE emp_id=?";
        int i = jdbcTemplate.update(sql, 1300.00, 5);
        System.out.println(i);
    }
}
