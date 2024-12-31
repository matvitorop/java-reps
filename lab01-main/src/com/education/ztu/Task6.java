package com.education.ztu;
import java.util.Scanner;

public class Task6 {
    public static int[] generateFibonacci(int n) {
        int[] fibonacci = new int[n];
        if (n > 0) {
            fibonacci[0] = 1;
        }
        if (n > 1) {
            fibonacci[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];  // Формула для числа Фібоначчі
        }
        return fibonacci;
    }
    public static int[] reverseArray(int[] array) {
        int n = array.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = array[n - 1 - i];
        }
        return reversed;
    }

    public static void printArray(int[] array, String message) {
        System.out.print(message + ": ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount of fibonacci: ");
        int n = scanner.nextInt();

        int[] fibonacciArray = generateFibonacci(n);

        int[] reversedArray = reverseArray(fibonacciArray);

        printArray(fibonacciArray, "Fibonacci array");
        printArray(reversedArray, "Reversed fibonacci array");
    }
}
