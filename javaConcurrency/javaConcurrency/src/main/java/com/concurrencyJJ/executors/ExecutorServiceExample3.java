package com.concurrencyJJ.executors;

import java.util.concurrent.*;

public class ExecutorServiceExample3 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(newCallable("Task-1"));
        System.out.println(future.isDone());
        try {
            //returns the object returned by the callable because the submitted task is a runnable
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());
        service.shutdown();
    }

    private static Callable<String> newCallable(String taskName) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Thread.currentThread().getName() + ": " + taskName;
            }
        };
    }
}
