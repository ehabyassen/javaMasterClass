package com.concurrencyJJ.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample6 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.submit(() -> System.out.println("Task-" + finalI));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        service.shutdown();
    }
}
