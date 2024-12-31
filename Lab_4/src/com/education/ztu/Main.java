package com.education.ztu;
import java.util.Scanner;

public class Main {
    //TASK 1
    public static void stringContainer(String string) {
        if(string.length()>0) {

            System.out.println("Last char of string is "+string.charAt(string.length()-1));

            System.out.println(string.endsWith("!!!") ? "String ends with !!!" : "String doesnt ends with !!!");

            System.out.println(string.startsWith("I learn") ? "String starts with \"I learn\"" : "String doesnt start with \"I learn\"");

            System.out.println(string.contains("Java") ? "String contains Java. Position of word Java starts on " + string.indexOf("Java") : "String doesnt contains Java");

            System.out.println("Result of changing all a letters on o: "+string.replace("a", "o"));

            System.out.println("Upper case string: "+string.toUpperCase());

            System.out.println("Lower case string: "+string.toLowerCase());

            System.out.println("String without word Java: "+string.replace("Java", ""));
        }else{
            System.out.println("Empty string");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String string = sc.nextLine();

        stringContainer(string);
    }
}