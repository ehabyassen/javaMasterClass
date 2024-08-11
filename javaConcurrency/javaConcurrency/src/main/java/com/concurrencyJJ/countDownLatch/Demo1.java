package com.concurrencyJJ.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Demo1 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            System.out.println(Thread.currentThread().getName() + " waiting for a signal to proceed...");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " proceeding...");
            System.out.println(Thread.currentThread().getName() + " finished...");
        }, "Thread-1");

        System.out.println(Thread.currentThread().getName() + " started...");
        t.start();
        System.out.println(Thread.currentThread().getName() + " finishing some work...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished the work...");
        System.out.println(Thread.currentThread().getName() + " signaling the waiting thread...");
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + " signaled the waiting thread...");
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
