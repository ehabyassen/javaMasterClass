package com.concurrencyJJ.completableFuture;

import java.util.concurrent.*;

public class Demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo1 demo = new Demo1();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = demo.calcAsync(service);

        Thread t1 = new Thread(() -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished...");
        }, "Thread-1");
        t1.start();

        service.shutdown();
        System.out.println(Thread.currentThread().getName() + " finished...");
    }

    public Future<String> calcAsync(ExecutorService executorService) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        executorService.submit(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished...");
            completableFuture.complete("Test");
        });
        return completableFuture;
    }
}
