package com.education.ztu.tasks;

import com.education.ztu.MyRunThread;

public class Task2 {
    public static void main(String[] args) {
        MyRunThread myRunThread = new MyRunThread();

        Thread threadOne = new Thread(myRunThread);
        Thread threadTwo = new Thread(myRunThread);
        Thread threadThree = new Thread(myRunThread);

        threadOne.start();
        threadTwo.start();
        threadThree.start();

        try {
            System.out.println("Main thread is sleeping");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        threadOne.interrupt();
        threadTwo.interrupt();
        threadThree.interrupt();
    }
}
