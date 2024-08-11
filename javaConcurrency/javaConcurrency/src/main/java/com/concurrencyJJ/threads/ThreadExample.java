package com.concurrencyJJ.threads;

public class ThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello from " + Thread.currentThread().getName()));
        thread.start();
    }
}
