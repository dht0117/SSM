package com.atguigu.utils;
/**
 * 如果将切面类中的方法，动态的在目标方法各个位置运行
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
@Aspect     //告诉spring这个是切面类
@Component
public class LogUtils {
    /**
     * 告诉Spring每个方法都什么时候运行
     * @Before  目标方法运行之前  -----------          前置通知
     * @After    目标方法运行之后       --------------    后置通知
     * @AfterReturning   在目标方法正常返回之后----------------返回通知
     * @AfterThrowing   抛出方法异常之后运行-----------------异常通知
     * @Around 环绕  ----------环绕通知
     */
    //想在执行目标方法之前执行 写切入表达式
    //execution(访问权限，返回值类型，方法签名)
//    @Before("execution(public int com.atguigu.impl.MyCalculator.*(int,int))")
    public static void logStart(JoinPoint joinPoint){
        //获取目标方法运行时的参数
        Object[] args = joinPoint.getArgs();
        //获取到方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("["+name+"]方法开始执行，用的参数列表是"+Arrays.asList(args));
    }
    //目标方法正常执行之后执行

    /**
     * 切入点表达式的写法：
     * 固定格式：execution(访问权限 返回值类型 方法全类名(参数表))
     * 通配符：
     *      *：
     *      1.匹配一个或多个字符
     *      2.匹配任意一个参数
     *      ..：
     *      1.匹配任意多个参数，任意类型
     *      2.匹配任意多层路径
     */

    //添加result后必须告诉spring  result是用来接收返回值的    returning = "result"
//    @AfterReturning(value = "execution(public int com.atguigu.impl.MyCalculator.*(int,int))",returning = "result")
    public static void logReturn(JoinPoint joinPoint,Object result){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("["+joinPoint.getSignature().getName()+"]方法正常执行完成，计算结果是"+result);

    }

    /**
     * 可以在通知方法运行时，拿到目标方法的详细信息
     * 1.只需为通知的方法参数列表上写一个参数
     *      JoinPoint joinPoint:封装了当前目标方法的详细信息
     * 2.告诉Spring那个参数是用来接收结果的，那个参数是同来接收异常的
     */
    //目标方法出现异常时执行
//    @AfterThrowing(value = "execution(public int com.atguigu.impl.MyCalculator.*(int,int))",throwing = "exception")
    public static void logException(JoinPoint joinPoint,Exception exception){

        System.out.println("["+joinPoint.getSignature().getName()+"]方法执行异常"+exception);

    }

    @Pointcut("execution(public int com.atguigu.impl.MyCalculator.*(int,int))")
    public void hahaMyPoint(){};

//    @After("hahaMyPoint()")
    public static void logFinally(JoinPoint joinPoint){

        System.out.println("["+joinPoint.getSignature().getName()+"]方法最终结束了...");
    }
    /**
     * 环绕通知 @Around：Spring中强大的通知
     * 实际上是动态代理
     * try{
     *     //前置通知
     *     method.invoke()
     *     //返回通知
     * }catch(){
     *     //异常通知
     * }finally{
     *     //后置通知
     * }
     * 四合一通知就是环绕通知
     * 环绕通知中有一个参数  ProceedingJoinPoint pjp
     */
    @Around("hahaMyPoint()")
    //ctrl+H打开继承树
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
