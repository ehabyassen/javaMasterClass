package com.concurrencyJJ.blockingQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample1 {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("Thread-1: consumed " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                String element = "Element-" + i;
                System.out.println("Thread-2: produced " + element);
                try {
                    queue.put(element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
