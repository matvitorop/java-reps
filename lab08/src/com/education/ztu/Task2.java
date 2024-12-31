package com.education.ztu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Task2 {
    public static void main(String[] args) {
        // TASK A
        Predicate<String> isNumeric = s -> {
            try{
                Double.parseDouble(s);
                return true;
            }catch(NumberFormatException e){
                return false;
            }
        };
        Predicate<String> isNotEmpty = s -> !s.isEmpty();

        System.out.println(isNumeric.and(isNotEmpty).test(" 123"));

        // TASK B
        Consumer<String> consumer = d -> System.out.println("Пара почалась о 8:30");
        Consumer<String> consumerOne = d -> System.out.println("Пара зікінчилась о 9:50");

        Consumer<String> result = consumer.andThen(consumerOne);

        result.accept("Робочий день розпочався");

        // TASK C
        Supplier<String> uppercaseMessage = () -> "example text".toUpperCase();
        System.out.println(uppercaseMessage.get());

        // TASK D
        Function<String, Integer> multiplyNumbers = s -> Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);

        String numbers = "2 3 4";
        System.out.println("Product of numbers: " + multiplyNumbers.apply(numbers));

    }
}
