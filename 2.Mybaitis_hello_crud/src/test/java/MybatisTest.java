import com.aiguigu.dao.EmployeeDao;
import com.atguigu.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initsqlSessionFactory() throws IOException {
        String resources="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.getEmpById(1);
        System.out.println(employee);
    }
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        int i = employeeDao.insertEmployee(new Employee(null, "张三", 1, "55555@qq.com"));
        System.out.println(i);
    }
    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        employeeDao.deleteEmployee(5);
    }
    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee emp = employeeDao.getEmpById(1);
        employeeDao.updateEmployee(new Employee(4,"王五",1,"666@qq.com"));
    }
}
