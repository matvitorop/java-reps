package com.education.ztu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Task4 {
    public static void main(String[] args) {
        Deque<Product> queue = new ArrayDeque<Product>();

        Product productOne = new Product("Banana", 3000, 100, "food");
        Product productTwo = new Product("Apple", 1000, 50, "food");
        Product productThree = new Product("Iphone", 45000, 333, "technique");
        Product productFour = new Product("Samsung", 12, 666, "technique");
        Product productFive = new Product("Bottle", 12345, 123, "plastic products");
        Product productSix = new Product("Lamp", 54321, 321, "technique");

        //push
        Task3.skipPlaceAndTask("Push:");
        queue.push(productOne);
        queue.push(productTwo);

        System.out.println(queue.peek());

        //offerLast
        Task3.skipPlaceAndTask("Offer last:");
        queue.offerLast(productThree);

        System.out.println(queue.getLast());

        //getFirst
        Task3.skipPlaceAndTask("getFirst:");
        System.out.println(queue.getFirst());

        //peekLast
        Task3.skipPlaceAndTask("Peek Last:");
        System.out.println(queue.peekLast());

        //pop
        Task3.skipPlaceAndTask("Pop:");
        System.out.println(queue.pop());

        //removeLast
        Task3.skipPlaceAndTask("Remove Last:");
        System.out.println(queue.removeLast());

        //pollLast
        Task3.skipPlaceAndTask("Poll last:");
        System.out.println(queue.pollLast());

    }
}
