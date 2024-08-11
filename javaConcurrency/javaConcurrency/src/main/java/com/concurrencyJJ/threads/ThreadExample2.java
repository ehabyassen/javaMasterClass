package com.concurrencyJJ.threads;

public class ThreadExample2 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running...");
    }
}