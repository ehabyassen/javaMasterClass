package com.oracle.concurrency;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) {
        HelloThread t1 = new HelloThread();
        t1.start();
    }
}
