package com.atguigu.impl;

import com.atguigu.inter.Calculator;
import org.springframework.stereotype.Service;


public class MyCalculator implements Calculator {
    public int add(int a, int b) {
       int result=a+b;
       return result;
    }

    public int sub(int a, int b) {
        int result=a-b;
        return result;
    }

    public int mul(int a, int b) {
        int result=a*b;
        return result;
    }

    public int div(int a, int b) {
        int result=a/b;
        return result;
    }
}
