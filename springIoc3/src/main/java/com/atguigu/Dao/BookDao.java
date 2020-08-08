package com.atguigu.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * id默认是类名首字母小写
 *
 */
//第一个注解括号内可以修改id
//多实例的--Scope
@Repository
//@Scope(value = "prototype")
public class BookDao {
//    @Autowired
//    private DataSource dataSource;

    public void saveBook(){
//        dataSource.getConnection();
        System.out.println("图书已经保存了!!");
    }
}
