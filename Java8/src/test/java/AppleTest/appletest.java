package AppleTest;

import chapter02.Apple;
import chapter02.Predicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class appletest {

    @Test
    public void test1(){
        System.out.println("lambda表达式test1");
        Thread t=new Thread(()-> System.out.println("hello world!"));
        t.start();
    }
    /**
     * 筛选出绿色的
     * @param inventory
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for (Apple apple:inventory){
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 根据颜色来筛选
     * @param inventory
     * @param color
     * @return
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result=new ArrayList<>();
        for (Apple apple:inventory){
            if (apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * lambda表达式
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result=new ArrayList<>();
        for (T e:list){
            if (p.test(e)){
                result.add(e);
            }
        }
        return  result;
    }

}
