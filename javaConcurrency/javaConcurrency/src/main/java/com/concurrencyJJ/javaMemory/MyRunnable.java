package com.concurrencyJJ.javaMemory;

public class MyRunnable implements Runnable {

    private int count = 0;

    private final Object lock = new Object();

    @Override
    public void run() {
        System.out.println(new Object());
        synchronized (lock) {
            for (int i = 0; i < 1_000_000; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName() + ": " + count);
        }
    }
}
