package com.concurrency.threadSignaling.improved;

public class Demo {

    public static void main(String[] args) {
        SignalCarrier signalCarrier = new SignalCarrier();

        Thread waitingThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " will wait...");
            signalCarrier.doWait();
            System.out.println(Thread.currentThread().getName() + " is notified...");
        });

        Thread notifyingThread = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " will sleep for 2 seconds...");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " woke up...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " will notify the waiting thread...");
            signalCarrier.doNotify();
            System.out.println(Thread.currentThread().getName() + " notified the waiting thread...");
        });

        waitingThread.start();
        notifyingThread.start();
    }
}
