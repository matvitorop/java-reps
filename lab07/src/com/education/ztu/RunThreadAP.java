package com.education.ztu;

public class RunThreadAP implements Runnable {
    private static int result = 1;

    private synchronized void printProgression(){
        for (int i = 0; i < 100; i++)
        {
            System.out.print(result + " ");
            result += 1;
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

    @Override
    public void run() {
        printProgression();
    }
}
