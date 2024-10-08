package com.concurrencyJJ.threads;

public class ThreadExample5 {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Lambda Runnable is running...");
        Thread thread = new Thread(runnable);
        thread.start();
    }
}