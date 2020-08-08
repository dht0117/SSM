package Lambda;

import java.util.Arrays;

public class ComparatorLambda {
    public static void main(String[] args) {
        Person[] array={
                new Person("lalal01",18),
                new Person("lalal02",22),
                new Person("lalal01",19),
        };
        Arrays.sort(array,( a, b)-> {
            return a.getAge() - b.getAge();
        });
        for (Person p:array){
            System.out.println(p);
        }
    }
}
