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

    /**
     * 事务细节：
     * isolation-Isolation    事务的隔离级别
     * propagation--Propagation   事务的传播行为
     *
     * noRollbackFor-----Class[]      哪些异常事务可以不回滚
     * noRollbackForClassName-------String[]
     * rollbackFor------------Class[]    哪些异常事务需要回滚
     * rollbackForClassName------------String[]
     *
     *
     * readOnly-----boolean   设置事务为只读事务:
     *                          可以进行事务优化；
     *                          readOnly=true：加快查询速度，不管事务那一堆操作
     *timeout-----------int（以s为单位）   超时，事务超出指定执行时长后自动终止回滚
     *
     * @param username
     * @param isbn
     */

    @Transactional(timeout = 3,noRollbackFor = {ArithmeticException.class,NullPointerException.class})
    public void checkout(String username,String isbn){
        //减库存

        bookDao.updateStock(isbn);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //获取价格
        int price = bookDao.getPrice(isbn);
        //减余额
        bookDao.updateBalance(username,price);
        //int i=10/0;    noRollbackFor  设置了以后就不会滚 虽然出现异常 但是数据库的数据还会修改成功
    }
}
