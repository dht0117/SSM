package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    /**
     * 结账：传入那个用户买个那本书
     * @param username
     * @param isbn
     */

    @Transactional
    public void checkout(String username,String isbn){
        //减库存
        bookDao.updateStock(isbn);
        //获取价格
        int price = bookDao.getPrice(isbn);
        //减余额
        bookDao.updateBalance(username,price);
    }
}
