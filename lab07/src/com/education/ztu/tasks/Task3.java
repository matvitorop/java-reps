package com.education.ztu.tasks;

import com.education.ztu.RunThreadAP;
import com.education.ztu.RunThreadAPUpdated;

public class Task3 {
    public static void main(String[] args) {
        //TASK 3
        RunThreadAP task = new RunThreadAP();

        //Thread thread1 = new Thread(task, "Thread1");
        //Thread thread2 = new Thread(task, "Thread2");
        //Thread thread3 = new Thread(task, "Thread3");

        //thread1.start();
        //thread2.start();
        //thread3.start();

        //TASK 4
        RunThreadAPUpdated taskOne = new RunThreadAPUpdated();
        Thread thread1 = new Thread(taskOne, "Thread1");
        Thread thread2 = new Thread(taskOne, "Thread2");
        Thread thread3 = new Thread(taskOne, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
