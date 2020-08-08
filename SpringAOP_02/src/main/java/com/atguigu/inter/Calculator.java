package com.atguigu.inter;

import org.springframework.stereotype.Service;

@Service
/**
 * 接口不加载容器中
 * 实际上可以加，加了也不创建对象，只要是接口
 */
public interface Calculator {
    public  int  add(int a,int b);
    public  int  sub(int a,int b);
    public  int  mul(int a,int b);
    public  int  div(int a,int b);

}
