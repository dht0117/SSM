package com.atguigu.controller;

import com.atguigu.book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(){
        System.out.println("handle01..........");
        return "success";
    }

    /**
     * SpringMVC如何获取请求所带的信息
     * @RequestParam: 获取请求参数 value：指定要获取的参数的key   required：这个参数是否必须的  defaultValue:默认值，没带就是null
     * @RequestHeader: 获取请求头中的某个key对应的值
     * @CookieValue:
     *
     * @RequestParam("user")     获取得是book？user=     后边的user部分
     * @PathVariable("user) /book/{bid}   获取得是bid
     */
    @RequestMapping("/handle01")
    public String handle02(String username,
                           @RequestHeader("User-Agent") String userAgent,
                           @CookieValue("JSESSIONID") String jid){
        System.out.println("这个变量值"+username);
        System.out.println("请求头中浏览器的信息："+userAgent);
        System.out.println("cookie中的jid："+jid);
        return "success";
    }

    /**
     * 提交信息有可能乱码：
     * 请求乱码：
     *          GET请求：改server.xml中8080端口加上URIEncoding=“UTF-8”
     *          POST请求：
     *          在获取第请求参数之前设置
     *          request.setCharacterEncoding("UTF-8")
     * 响应乱码：
     *          response.setContentType("text/html;charset=utf-8")
     * @param book
     * @return
     */


    @RequestMapping("/book")
    public String handel03(Book book){
        System.out.println("图书的信息为："+book);
        return "success";
    }
    @RequestMapping("handle03")
    public String handle03(HttpSession httpSession, HttpServletRequest request){
        request.setAttribute("reqParam","我是请求域中的");
        httpSession.setAttribute("sessionParam","我是Session域中的");
        return "success";
    }
}
