package com.education.ztu;

public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Current state - "+ getState());
        for (int i = 0; i<10000; i++){
            System.out.println("I love programming!");
        }
        System.out.println("Current state - "+ getState());
    }

    public static void main(String[] args) {
    }
}