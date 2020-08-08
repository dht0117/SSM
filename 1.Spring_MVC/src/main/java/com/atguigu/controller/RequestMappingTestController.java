package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 为当前类所有的方法请求地址提供一个基准路径
 * /haha   ----------前面的/加不加都可以 规范的写还是加上
 */
@Controller
@RequestMapping("/haha")
public class RequestMappingTestController {
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("RequestMappingTest......+handle01");
        return "success";
    }

    /**
     * RequestMapping的其他属性
     * method:限定请求方式   【GET】,
     *     HEAD,
     *     【POST】,
     *     PUT,
     *     PATCH,
     *     DELETE,
     *     OPTIONS,
     *     TRACE;
     *     method = RequestMethod.POST 只接受这种类型的请求，默认的是什么都可以；
     *     不是规定的方式就报错     405   4xx：都是客户端错误
     * params:规定请求参数 params和headers支持简单的表达式：
     *          param1:表示请求必需包含名为param1的请求参数；
     *          eg：params={"usernmae"}:
     *              发送请求的时候必须带上名为username的参数：没带就是404
     *          ！param:表示请求不能带名为param1的请求参数
     * headers: 规定请求头
     * consumes: 只接受内容类型是那种的请求，规定请求头中的Content-type
     * produces: 告诉浏览器返回的内容类型是什么，给响应头加上Content-type
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.POST)
    public String handle02(){

        System.out.println("RequestMappingTest......+handle02");
        return "success";
    }
    @RequestMapping(value = "/handle03",params = {"username"})
    public String handle03(){
        System.out.println("handle03.....");
        return "success";
    }

    //路径上可以有占位符，占位符语法就是可以在任意路径的地方写一个（变量名）
    // user/admin
    //路径上的占位符只能占一层

    @RequestMapping("/user/{id}")
    public String pathVariableTest(@PathVariable("id") String id){
        System.out.println("路径上的占位符的值为"+id);
        return "success";
    }
}
