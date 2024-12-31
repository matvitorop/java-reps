package com.education.ztu;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void sell(int amount) {
        if (amount > quantity) {
            System.out.println("Недостатньо товару на складі!");
        } else {
            quantity -= amount;
            System.out.println("Продукт " + name + " продано в кількості " + amount + " шт.");
        }
    }

    @Override
    public String toString() {
        return "Amount of "+ getName() + " is "+ getPrice();
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
