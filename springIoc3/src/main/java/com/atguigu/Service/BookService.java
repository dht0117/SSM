package com.atguigu.Service;

import com.atguigu.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void save(){
        System.out.println("bookService..正在调用dao保存图书");
        bookDao.saveBook();
    }
}
