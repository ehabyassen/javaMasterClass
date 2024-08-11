package com.concurrencyJJ.threads;

public class ThreadExample4 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable is running...");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}