import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Mybatistest {
    @Test
    public void test() throws IOException {
        String resources="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee e = employeeDao.getEmpById(1);
        System.out.println(e);
    }
}
