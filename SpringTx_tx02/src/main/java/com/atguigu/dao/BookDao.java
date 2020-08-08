package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 1.减余额
     */
    public void updateBalance(String userName,int price){
        String sql="UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql,price,userName);
    }

    /**
     * 按照图书的编号获取价格
     * @param isbn
     * @return
     */
    public int getPrice(String isbn){
        String sql="SELECT price FROM book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }
    /**
     * 减少库存
     */
    public void updateStock(String isbn){
        String sql="UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql,isbn);

    }
}
