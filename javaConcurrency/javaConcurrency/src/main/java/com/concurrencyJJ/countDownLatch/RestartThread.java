package com.concurrencyJJ.countDownLatch;

public class RestartThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started...");
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " STARTED...");
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }
}
