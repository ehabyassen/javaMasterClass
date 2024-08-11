package com.concurrencyJJ.threads;

public class ThreadExample8 {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running...");

            System.out.println(Thread.currentThread().getName() + " will sleep for 2 seconds...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " woke up and finished...");
        }).start();
    }
}