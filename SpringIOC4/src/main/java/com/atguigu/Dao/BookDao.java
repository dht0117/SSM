package com.atguigu.Dao;

import com.atguigu.Bean.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book>{
    @Override
    public void save() {
        System.out.println("BookDao....保存图书..");
    }
}
