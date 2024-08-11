package com.concurrency.waitNotify;

public class DemoWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        new DemoWaitNotify().foo();
    }

    public void foo() throws InterruptedException {
        DemoWait demoWait = new DemoWait();
        Thread t = new Thread(demoWait);
        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " is " + t.getState());
        t.start();
        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " is " + t.getState());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " is " + t.getState());

        synchronized (demoWait) {
            System.out.println(Thread.currentThread().getName() + ": " + demoWait);
            demoWait.notify();
        }
    }
}

class DemoWait implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getName() + " is " + Thread.currentThread().getState());
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + ": " + this);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}