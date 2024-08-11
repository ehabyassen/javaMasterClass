package com.oracle.concurrency;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new HelloRunnable());
        t1.start();
    }
}
