package com.atguigu.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogUtils {
    public static void logStart(Method method,Object... args){
        System.out.println("["+method.getName()+"]方法开始执行，用的参数列表是"+ Arrays.asList(args));
    }

    public static void logReturn(Method method,Object result){
        System.out.println("["+method.getName()+"]方法正常执行完成，计算结果是"+result);

    }

    public static void logException(Method method,Exception e){
        System.out.println("["+method.getName()+"]方法执行异常"+e);

    }

    public static void logFinally(Method method){
        System.out.println("["+method.getName()+"]方法最终结束了...");
    }
}
