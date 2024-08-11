
package com.concurrencyJJ.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolMainDemo {

    public static void main(String[] args) {
        try (ExecutorService threadPool = Executors.newFixedThreadPool(3)) {

            for (int i = 0; i < 10; i++) {
                int taskNumber = i;
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName() + ": Task_" + taskNumber);
                });
            }
            threadPool.shutdown();
        }
    }
}
