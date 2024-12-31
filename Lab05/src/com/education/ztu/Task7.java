package com.education.ztu;

import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 20, 10));
        System.out.println("Початковий масив: " + numbers);

        // Collections.sort()
        Collections.sort(numbers);
        System.out.println("Після сортування: " + numbers);

        // Collections.binarySearch()
        int index = Collections.binarySearch(numbers, 30);
        System.out.println("Індекс елемента 30 після бінарного пошуку: " + index);

        // Collections.reverse()
        Collections.reverse(numbers);
        System.out.println("Після реверсу: " + numbers);

        // Collections.shuffle()
        Collections.shuffle(numbers);
        System.out.println("Після перемішування: " + numbers);

        // Collections.fill()
        Collections.fill(numbers, 100);
        System.out.println("Після заповнення значенням 100: " + numbers);

        // max, min
        numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 20, 10));

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Максимальне значення: " + max);
        System.out.println("Мінімальне значення: " + min);

        // Collections.copy()
        List<Integer> copyList = new ArrayList<>(Arrays.asList(new Integer[numbers.size()]));
        Collections.copy(copyList, numbers);
        System.out.println("Копія масиву: " + copyList);

        // Collections.rotate()
        Collections.rotate(numbers, 2);
        System.out.println("Після обертання на 2 позиції: " + numbers);

        // Collections.checkedCollection()
        Collection<Integer> checkedCollection = Collections.checkedCollection(numbers, Integer.class);
        try {
            checkedCollection.add(60);
            System.out.println("Перевірена колекція після додавання 60: " + checkedCollection);
            // checkedCollection.add("String");
        } catch (ClassCastException e) {
            System.out.println("Виявлено неправильний тип елемента: " + e.getMessage());
        }

        // Collections.frequency()
        int frequency = Collections.frequency(numbers, 20);
        System.out.println("Частота появи елемента 20: " + frequency);
    }
}
