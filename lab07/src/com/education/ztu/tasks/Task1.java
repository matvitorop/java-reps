package com.education.ztu.tasks;

import com.education.ztu.MyThread;

public class Task1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("Current state - "+ myThread.getState());
        System.out.println("Launching thread: ");

        myThread.start();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread state while running: " + myThread.getState());
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Name of thread: " + myThread.getName());
        System.out.println("Priority of thread: " + myThread.getPriority());
        System.out.println("Is thread alive: " + myThread.isAlive());
        System.out.println("Is daemon thread: " + myThread.isDaemon());

        myThread.setName("MyUpdatedThread");
        myThread.setPriority(10);

        System.out.println("New name of thread: " + myThread.getName());
        System.out.println("New priority of thread: " + myThread.getPriority());

        try {
            myThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Thread thread = Thread.currentThread();

        System.out.println("\nName of thread: " + thread.getName());
        System.out.println("Priority of thread: " + thread.getPriority());
        System.out.println("Current state of main thread: " + thread.getState());
    }
}
