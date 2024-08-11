package com.concurrency.threadSignaling.missedSignals.solution;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        SignalCarrier signalCarrier = new SignalCarrier();

        Thread waitingThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " will wait...");
            signalCarrier.doWait();
            System.out.println(Thread.currentThread().getName() + " is notified...");
        });

        Thread notifyingThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " will notify the waiting thread...");
            signalCarrier.doNotify();
            System.out.println(Thread.currentThread().getName() + " notified the waiting thread...");
        });

        notifyingThread.start();
        Thread.sleep(1000);
        waitingThread.start();
    }
}
