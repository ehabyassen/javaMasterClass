package com.concurrencyJJ.executors;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample4 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        List<Callable<String>> callables = List.of(
                newCallable("Task-1", 1000),
                newCallable("Task-2", 0),
                newCallable("Task-3", 0)
        );
        try {
            String result = service.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    private static Callable<String> newCallable(String taskName, long millis) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Thread.currentThread().getName() + ": " + taskName;
            }
        };
    }
}
