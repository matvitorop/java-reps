package com.education.ztu;
import java.util.Scanner;

public class Task5 {
    public static int sumOfDigits(int number){
        int sum = 0;
        while(number > 0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();
        int sum = sumOfDigits(number);
        System.out.println("The sum of the digits is " + sum);
    }
}
