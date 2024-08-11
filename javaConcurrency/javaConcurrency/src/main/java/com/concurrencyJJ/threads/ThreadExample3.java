package com.concurrencyJJ.threads;

public class ThreadExample3 {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable is running...");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}