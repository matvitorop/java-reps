package com.education.ztu.tasks;

import java.util.Scanner;

public class Task5 {
    private static final Object lock = new Object();
    private static String data = null;

    public static void main(String[] args) {
        Thread readerThread = new Thread(new Reader(), "Reader");
        Thread printThread = new Thread(new Printer(), "Print");

        readerThread.start();
        printThread.start();
    }

    public static class Reader implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter the text: ");
                String text = scanner.nextLine();

                synchronized (lock) {
                    data = text;
                    lock.notify();
                }
                if(text.equalsIgnoreCase("exit")) {
                    break;
                }
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }

    public static class Printer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        lock.wait();
                        if (data.equalsIgnoreCase("exit")) break;
                        System.out.println("Received: " + data);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
