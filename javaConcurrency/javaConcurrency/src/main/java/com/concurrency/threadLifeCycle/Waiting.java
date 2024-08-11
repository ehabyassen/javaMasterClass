package com.concurrency.threadLifeCycle;

public class Waiting implements Runnable {

    static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new Waiting());
        System.out.println(Thread.currentThread().getName() + ": " + t1.getName() + " is " + t1.getState());
        t1.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + t1.getName() + " is " + t1.getState());
        Thread t2 = new Thread(new DemoWaitingStateRunnable());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            //ignore e
        }
    }
}

class DemoWaitingStateRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //ignore e
        }
        System.out.println(Thread.currentThread().getName() + ": " + Waiting.t1.getName() + " is " + Waiting.t1.getState());
    }
}
