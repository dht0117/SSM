package com.atguigu.Servlet;

import com.atguigu.Dao.BookDao;
import com.atguigu.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 属性的自动注入
 * @Autowired Spring会自动为这个属性赋值，-------去容器中找这个属性对应的组件
 */
@Controller
public class BookServlet {
    //自动的为这个属性赋值
//    @Autowired
//    private BookService bookService;

    public void doGet(){
        System.out.println("BookServlet");
//        bookService.save();
    }

    /**
     * 在方法上添加Autowired会自动为参数自动注入
     * @param bookDao
     * @param bookService
     */
    @Autowired
    public void hah(BookDao bookDao,BookService bookService){
        System.out.println("Spring运行了这个方法..."+bookDao+"==>"+bookService);
    }

}
