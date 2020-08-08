import com.atguigu.impl.MyCalculator;
import com.atguigu.inter.Calculator;
import com.atguigu.proxy.CalculatorProxy;
import org.junit.Test;

import java.util.Arrays;

public class AOPTest {
    @Test
    public void test1(){
        Calculator calculator=new MyCalculator();
        int result = calculator.add(1, 2);
        System.out.println(result);

        System.out.println("===================");

        //如果是拿到了这个对象的代理对象，代理对象执行
        Calculator proxy= CalculatorProxy.getproxy(calculator);
        proxy.add(1,6);

        System.out.println("===================");
        //代理对象和被代理对象唯一能产生的关联就是实现了同一个接口
        //[interface com.atguigu.inter.Calculator]
        /**
         * jdk默认的动态代理，如果目标对象没有实现任何接口，是无法为他创建代理对象的！！！！
         */
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
        Calculator proxy2=CalculatorProxy.getproxy(calculator);
        proxy2.div(2,1);
    }
}
