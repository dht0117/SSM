package com.atguigu.Service;

import com.atguigu.Bean.Book;
import com.atguigu.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends BaseService<Book>{}
