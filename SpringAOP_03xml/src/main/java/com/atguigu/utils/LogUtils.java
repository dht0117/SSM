package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;


public class LogUtils {
    public static void logStart(JoinPoint joinPoint){
        //获取目标方法运行时的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]方法开始执行，用的参数列表是"+ Arrays.asList(args));
    }
    public static void logReturn(JoinPoint joinPoint,Object result){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("["+joinPoint.getSignature().getName()+"]方法正常执行完成，计算结果是"+result);

    }
    public static void logException(JoinPoint joinPoint,Exception exception){

        System.out.println("["+joinPoint.getSignature().getName()+"]方法执行异常"+exception);

    }

    public static void logFinally(JoinPoint joinPoint){

        System.out.println("["+joinPoint.getSignature().getName()+"]方法最终结束了...");
    }
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String name = pjp.getSignature().getName();
        Object proceed = null;
        try {
            //就是利用反射调用目标方法即可，就是method.invoke（obj，args）
            System.out.println("【环绕前置通知】【"+name+"方法开始】");
            proceed = pjp.proceed(args);
            System.out.println("【环绕返回通知】【"+name+"方法返回】，返回值是"+proceed);
        } catch (Throwable e) {
            System.out.println("【环绕异常通知】【"+name+"方法出现异常】，异常信息是"+e);
        } finally {
            System.out.println("【环绕后置通知】【"+name+"方法结束】");
        }
        return proceed;

    }
}
