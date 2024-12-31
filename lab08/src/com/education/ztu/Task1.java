package com.education.ztu;

import com.education.ztu.tools.Printable;

public class Task1 {
    public static void main(String[] args) {
        Printable printable = () -> System.out.println("Hello World");
        printable.print();
    }
}
