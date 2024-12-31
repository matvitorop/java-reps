package com.education.ztu;

public class MyRunThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {

            if(Thread.currentThread().isInterrupted()){
                System.out.println("Calculation is interrupted");
                return;
            }

            if(i%10 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
        System.out.println("Calculation is completed successfully");
    }
}
