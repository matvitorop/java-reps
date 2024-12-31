package com.education.ztu;
import java.util.NavigableSet;
import java.util.TreeSet;


import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        TreeSet<Product> tree = new TreeSet<Product>();

        tree.add(new Product("Banana", 3000, 100, "food"));
        tree.add(new Product("Apple", 1000, 50, "food"));
        tree.add(new Product("Iphone", 45000, 333, "technique"));
        tree.add(new Product("Samsung", 12, 666, "technique"));
        tree.add(new Product("Bottle", 12345, 123, "plastic products"));
        tree.add(new Product("Lamp", 54321, 321, "technique"));

        System.out.println("Перший елемент (first): " + tree.first());
        System.out.println("Останній елемент (last): " + tree.last());

        // headSet, subSet, tailSet
        System.out.println("Множина до продукту з ціною до 12345 (headSet): " + tree.headSet(new Product("MK", 12345, 50, "food")));
        System.out.println("Множина від продукту з ціною 3000 до 5000 (subSet): " + tree.subSet(new Product("DV", 3000, 50, "food"), new Product("FF", 5000, 50, "food")));
        System.out.println("Множина від продукту з ціною 14 і вище (tailSet): " + tree.tailSet(new Product("UY", 14, 50, "food")));

        // ceiling, floor, higher, lower
        System.out.println("Перший елемент, що не менший за 5000 (ceiling): " + tree.ceiling(new Product("SS", 5000, 50, "food")));
        System.out.println("Перший елемент, що не більший за 13 (floor): " + tree.floor(new Product("DH", 13, 50, "food")));
        System.out.println("Елемент, вищий за 12345 (higher): " + tree.higher(new Product("MN", 12345, 50, "food")));
        System.out.println("Елемент, нижчий за 1000 (lower): " + tree.lower(new Product("HJ", 1000, 50, "food")));

        // pollFirst, pollLast
        System.out.println("Видалення першого елемента (pollFirst): " + tree.pollFirst());
        System.out.println("Видалення останнього елемента (pollLast): " + tree.pollLast());

        // descendingSet
        NavigableSet<Product> descendingSet = tree.descendingSet();
        System.out.println("Елементи у зворотному порядку (descendingSet): " + descendingSet);

        System.out.println("Поточний стан множини: " + tree);

    }
}
