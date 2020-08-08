package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstController {
    @RequestMapping("/hello")
    public String firstcontroller(){
        System.out.println("测试成功。。");
        return "success";
    }
}
