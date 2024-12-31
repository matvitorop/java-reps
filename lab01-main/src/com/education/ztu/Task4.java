package com.education.ztu;
import java.util.Scanner;

public class Task4 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();

            int result = gcd(a, b);

            System.out.println("The biggest common divisor is "+result);
    }
}


