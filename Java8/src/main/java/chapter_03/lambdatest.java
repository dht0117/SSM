package chapter_03;

import chapter02.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lambdatest {
    private static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> result=new ArrayList<>();
        for (T s:result){
            if (p.test(s)){
                result.add(s);
            }
        }
        return result;
    }
    Predicate<String> nonEmptyStringPredicate=(String s)->!s.isEmpty();
//    Supplier<Apple> cl=Apple::new;   有空构造器时可以这样使用
        //有Apple（Integer weight）的构造函数时
//    Function<Integer,Apple> c2=Apple::new;
//    Apple a2=c2.apply(100);

}
