package com.atguigu.impl;

import com.atguigu.inter.Calculator;

public class MyCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
       int result=a+b;
       return result;
    }

    @Override
    public int sub(int a, int b) {
        int result=a-b;
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result=a*b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result=a/b;
        return result;
    }
}
