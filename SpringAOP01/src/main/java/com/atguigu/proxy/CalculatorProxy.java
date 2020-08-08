package com.atguigu.proxy;

import com.atguigu.inter.Calculator;
import com.atguigu.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 帮Calculator.java生成代理类对象
 */
public class CalculatorProxy {
    //为传入的参数对象创建一个代理对象
    //Calculator calculator被代理对象
    public static Calculator getproxy(Calculator calculator) {
        InvocationHandler h=new InvocationHandler() {
            /**
             *
             * @param proxy 代理对象，给jdk使用，任何时候都不要动这个对象
             * @param method  当前将要执行目标对象的方法
             * @param args 这个方法调用时传入外界的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行目标方法
                //目标方法的返回值
//                System.out.println("这是动态代理将要执行的方法........");

                Object result = null;
                try {
//
                    LogUtils.logStart(method,args);
                    result = method.invoke(calculator, args);
                    LogUtils.logReturn(method,result);
                }  catch (Exception e) {
                    LogUtils.logException(method,e);
                } finally {
                    LogUtils.logFinally(method);
                }
                //返回值必需返回出去外界才能拿到真正执行后的结果
                return result;
            }
        };
        Class<?>[] interfaces=calculator.getClass().getInterfaces();
        ClassLoader loader=calculator.getClass().getClassLoader();
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;
    }
}
