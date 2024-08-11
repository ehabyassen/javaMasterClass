package com.concurrencyJJ.producerConsumer;

import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {
            while (true) {
                long millis = System.currentTimeMillis();
                try {
                    queue.put(Thread.currentThread().getName() + ": " + millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sleep();
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    String task = queue.take();
                    System.out.println(Thread.currentThread().getName() + ": " + task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService producers = Executors.newFixedThreadPool(3);
        ExecutorService consumers = Executors.newFixedThreadPool(2);

        producers.execute(producer);
        consumers.execute(consumer);
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
