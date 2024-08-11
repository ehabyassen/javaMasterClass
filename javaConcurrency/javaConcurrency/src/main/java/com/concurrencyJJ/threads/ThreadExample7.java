package com.concurrencyJJ.threads;

public class ThreadExample7 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running..."), "Thread 1");
        Thread t2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running..."), "Thread 2");

        t1.start();
        t2.start();
    }
}