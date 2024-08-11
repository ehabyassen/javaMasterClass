package com.concurrency.threadSignaling.intro;

public class ThreadSignalingDemo {

    public static void main(String[] args) {
        Object signalObject = new Object();

        Thread waitingThread = new Thread(() -> {
            synchronized (signalObject) {
                System.out.println(Thread.currentThread().getName() + " synchronized on " + signalObject);
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    System.out.println(Thread.currentThread().getName() + " released the lock on " + signalObject);
                    signalObject.wait();
                    System.out.println(Thread.currentThread().getName() + " reacquired the lock on " + signalObject);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " released the lock on " + signalObject);
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (signalObject) {
                System.out.println(Thread.currentThread().getName() + " synchronized on " + signalObject);
                try {
                    System.out.println(Thread.currentThread().getName() + " will sleep for 2 seconds...");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " woke up...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                signalObject.notify();
                System.out.println(Thread.currentThread().getName() + " notified waiting thread on " + signalObject);
            }
            System.out.println(Thread.currentThread().getName() + " released the lock on " + signalObject);
        });

        waitingThread.start();
        notifyingThread.start();
    }
}
