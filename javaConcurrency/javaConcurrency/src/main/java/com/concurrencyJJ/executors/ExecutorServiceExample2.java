package com.concurrencyJJ.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample2 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<?> future = service.submit(newRunnable("Task-1"));
        System.out.println(future.isDone());
        try {
            //returns null because the submitted task is a runnable
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
        service.shutdown();
    }

    private static Runnable newRunnable(String taskName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": " + taskName);
            }
        };
    }
}
