package com.concurrencyJJ.threads;

public class ThreadExample6 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running..."), "The Thread");
        t.start();
    }
}