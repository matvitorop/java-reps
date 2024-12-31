package com.education.ztu.tools;

public class Product {
    String name;
    String brand;
    double price;
    int count;

    public Product(String name, String brand, double price, int count) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', brand='" + brand + "', price=" + price + ", count=" + count + "}";
    }
}