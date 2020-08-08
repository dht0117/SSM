import com.atguigu.impl.MyCalculator;
import com.atguigu.inter.Calculator;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AOPTest {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test1(){
        Calculator calculator=new MyCalculator();
        int result = calculator.add(1, 2);
        System.out.println(result);

        System.out.println("===================");

        //如果是拿到了这个对象的代理对象，代理对象执行
//        Calculator proxy= CalculatorProxy.getproxy(calculator);
//        proxy.add(1,6);

        System.out.println("===================");
        //代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
        //[interface com.atguigu.inter.Calculator]
        /**
         * jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为他创建代理对象的！！！！
         */
//        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
//        Calculator proxy2=CalculatorProxy.getproxy(calculator);
//        proxy2.div(2,1);
    }
    @Test
    public void test2(){
        //1.从ioc容器中拿到目标对象，注意：如果想要用类型，一定用它的接口类型，不用用它的本类
        //细节1：com.atguigu.impl.MyCalculator@6c0d7c83
        //class com.sun.proxy.$Proxy24
        //AOP的底层就是动态代理，容器中保存的组件是他的代理对象   $Proxy24当然不是本类的类型
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,5);
        bean.sub(5,1);
//        bean.div(2,0);
        System.out.println(bean);
        System.out.println(bean.getClass());
    }

    /**
     * 通知方法的执行顺序
     * try{
     *      @Before
     *      method.invoke(obj,args)
     *      @AfterReturning
     * }catch(){
     *      @AfterThrowing
     * }finally{
     *      @After
     * }
     *
     * 正常执行：@Before前置通知 -------@Afte后置通知r------@AfterReturning正常返回
     * 异常执行：@Before前置通知 -------@Afte后置通知r------@AfterThrowing方法异常
     */
    @Test
    public void test3(){
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(1,1);
        System.out.println("=====================");
    }
}
