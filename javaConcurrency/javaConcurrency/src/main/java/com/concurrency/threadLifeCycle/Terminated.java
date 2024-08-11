package com.concurrency.threadLifeCycle;

public class Terminated implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Terminated());
        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " is " + t.getState());

        t.start();
        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " is " + t.getState());

        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " is " + t.getState());
        System.out.println(t.isAlive());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Hello!");
    }
}
