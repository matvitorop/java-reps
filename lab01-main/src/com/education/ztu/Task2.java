package com.education.ztu;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int numOne = in.nextInt();

        System.out.println("Enter second number: ");
        int numTwo = in.nextInt();

        System.out.println("Summ of this number is " + (numOne + numTwo));
    }
}
