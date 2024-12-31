package com.education.ztu.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task6 {
    private static final int ARRAY_SIZE = 1_000_000_000;
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(100);
        }
        //Single thread
        long startTime = System.currentTimeMillis();
        int singleThreadSum = calculateSumSingleThread(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Однопотокова сума: " + singleThreadSum);
        System.out.println("Час виконання однопотокового варіанту: " + (endTime - startTime) + " мс");

        //Multi thread
        startTime = System.currentTimeMillis();
        int multiThreadSum = calculateSumMultiThread(array);
        endTime = System.currentTimeMillis();
        System.out.println("Багатопотокова сума: " + multiThreadSum);
        System.out.println("Час виконання багатопотокового варіанту: " + (endTime - startTime) + " мс");
    }

    private static int calculateSumSingleThread(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    private static int calculateSumMultiThread(int[] array) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        List<Future<Integer>> results = new ArrayList<>();
        int chunkSize = ARRAY_SIZE / THREADS_COUNT;

        for (int i = 0; i < THREADS_COUNT; i++) {
            final int start = i * chunkSize;
            final int end = (i == THREADS_COUNT - 1) ? ARRAY_SIZE : start + chunkSize;

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += array[j];
                }
                return sum;
            };
            results.add(executor.submit(task));
        }

        int totalSum = 0;
        for (Future<Integer> future : results) {
            try {
                totalSum += future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return totalSum;
    }
}
