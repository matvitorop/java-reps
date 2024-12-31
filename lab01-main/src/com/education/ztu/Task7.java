package com.education.ztu;

public class Task7 {
    public static void main(String[] args) {
        char [] alphabet = new char[26];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        System.out.println("Capital letters of the Latin alphabet");
        for (char ch : alphabet) {
            System.out.println(ch + "==>"+(int)ch);
        }

        System.out.println("\nLowercase letters of the Latin alphabet");
        for (int i = 0; i < alphabet.length; i++) {
            char lowercase = (char) ('a' + i);
            System.out.println(lowercase+"==>"+(int)lowercase);
        }
    }
}
