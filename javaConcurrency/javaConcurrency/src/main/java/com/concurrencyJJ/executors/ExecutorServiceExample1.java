package com.concurrencyJJ.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample1 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(getRunnable("Task-1"));
        service.execute(getRunnable("Task-2"));
        service.execute(getRunnable("Task-3"));

        service.shutdown();
    }

    private static Runnable getRunnable(String taskName) {
        return () -> System.out.println(Thread.currentThread().getName() + ": executing " + taskName);
    }
}
