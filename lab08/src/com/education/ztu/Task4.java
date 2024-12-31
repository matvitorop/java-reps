package com.education.ztu;

import java.util.Arrays;
import java.util.Optional;

public class Task4 {
    public static void main(String[] args) {
        Integer[] numbers = {10, 20, 30, 40, 50};
        //Integer[] numbers = {};

        Optional<Integer> max = Arrays.stream(numbers)
                .max(Integer::compareTo);

        String result = max.map(String::valueOf).orElse("No digits");
        System.out.println("Max value: " + result);

    }
}
