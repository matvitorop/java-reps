package com.education.ztu;

import com.education.ztu.tools.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Laptop", "Dell", 1200, 10));
        list.add(new Product("Phone", "Samsung", 800, 20));
        list.add(new Product("Tablet", "Apple", 900, 5));
        list.add(new Product("Headphones", "Sony", 150, 15));
        list.add(new Product("Laptop", "Dell", 1200, 10));
        list.add(new Product("Monitor", "LG", 300, 8));

        list.stream()
                .map(Product::getName)
                .forEach(System.out::println);

        list.stream()
                .filter(product -> product.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        int sum = list.stream()
                .map(Product::getCount)
                .reduce(0, (a,b)->a+b);

        System.out.println(sum);

        Map<String, List<Product>> map = list.stream()
                .collect(Collectors.groupingBy(Product::getBrand));

        map.forEach((brand, products) -> {
            System.out.println(brand);
            products.forEach(System.out::println);
        });

        List<Product> sortedProducts = list.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());

        System.out.println("Sorted elements:");
        sortedProducts.forEach(System.out::println);

    }
}
