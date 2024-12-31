package com.education.ztu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task6 {
    public static void main(String[] args) {
        HashMap<Integer, Product> productMap = new HashMap<>();

        productMap.put(1, new Product("Laptop", 1200, 100, "tech"));
        productMap.put(2, new Product("Smartphone", 800, 100, "tech"));
        productMap.put(3, new Product("Tablet", 600, 100, "tech"));

        //get
        System.out.println("Отримання продукту з ключем 2: " + productMap.get(2));

        //containsKey containsValue
        System.out.println("Чи містить ключ 3? " + productMap.containsKey(3));
        System.out.println("Чи містить значення 'Tablet'? " + productMap.containsValue(productMap.put(3, new Product("Tablet", 600, 100, "tech"))));

        //putIfAbsent
        productMap.putIfAbsent(4, new Product("Monitor", 300, 100, "tech"));
        System.out.println("Після putIfAbsent для ключа 4: " + productMap);

        //keySet values
        Set<Integer> keys = productMap.keySet();
        System.out.println("Ключі у HashMap: " + keys);

        System.out.println("Значення у HashMap: " + productMap.values());

        //putAll
        HashMap<Integer, Product> additionalProducts = new HashMap<>();
        additionalProducts.put(5, new Product("Keyboard", 50, 100, "tech"));
        additionalProducts.put(6, new Product("Mouse", 25, 100, "tech"));
        productMap.putAll(additionalProducts);
        System.out.println("Після додавання додаткових продуктів (putAll): " + productMap);

        //remove
        productMap.remove(1);
        System.out.println("Після видалення продукту з ключем 1: " + productMap);

        //size
        System.out.println("Розмір HashMap: " + productMap.size());

        //clear
        productMap.clear();
        System.out.println("Після очищення HashMap: " + productMap.isEmpty());

        productMap.put(1, new Product("Laptop", 1200, 100, "tech"));
        productMap.put(2, new Product("Smartphone", 800, 100, "tech"));
        productMap.put(3, new Product("Tablet", 600, 100, "tech"));

        //entrySet
        Set<Map.Entry<Integer, Product>> entries = productMap.entrySet();
        System.out.println("\nЕлементи в entrySet:");
        for (Map.Entry<Integer, Product> entry : entries) {
            System.out.println("Ключ: " + entry.getKey() + ", Значення: " + entry.getValue());

            if (entry.getKey() == 3) {
                entry.setValue(new Product("Updated tablet", 600, 100, "tech"));
            }
        }

        System.out.println("HashMap після змін в entrySet: " + productMap);
    }
}
