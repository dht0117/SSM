package chapter_04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static chapter_04.Dish.menu;
public class StreamTest {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishName=menu.stream()
                .filter(dish -> dish.getCalories()>300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishName);

    }
    List<String> lowCaloricDishedName=menu.stream()
            .filter(dish -> dish.getCalories()<400)
            .sorted(Comparator.comparing(Dish::getCalories))
            .map(Dish::getName)
            .collect(Collectors.toList());

    List<String> lowCaloricDishedNameParallel=menu.parallelStream()
            .filter(dish -> dish.getCalories()<400)
            .sorted(Comparator.comparing(Dish::getCalories))
            .map(Dish::getName)
            .collect(Collectors.toList());
}
