package com.education.ztu;

public class RunThreadAPUpdated implements Runnable {
    private static int result = 1;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
        {
            synchronized (this){
                System.out.print(result + " ");
                result += 1;
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Program finished");
    }
}
