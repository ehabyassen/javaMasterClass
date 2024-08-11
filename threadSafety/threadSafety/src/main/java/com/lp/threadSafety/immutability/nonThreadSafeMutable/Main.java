package com.lp.threadSafety.immutability.nonThreadSafeMutable;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            test(new MessageService(0));
        }
    }

    private static void test(MessageService service) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(random.nextLong(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int currentValue = service.getValue();
                try {
                    Thread.sleep(random.nextLong(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                service.setValue(currentValue + 1);
                //to solve this, we can synchronize a block of code where the read
                //and write to the value variable is done.
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.yield();
        }
        System.out.println("Value: " + service.getValue());
    }
}
