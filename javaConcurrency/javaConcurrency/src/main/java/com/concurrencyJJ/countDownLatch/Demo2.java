package com.concurrencyJJ.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Demo2 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started...");

        int numberOfWorkers = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numberOfWorkers);

        for (int i = 0; i < numberOfWorkers; i++) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        System.out.println(Thread.currentThread().getName() + " finishing some work...");
        sleep();
        System.out.println(Thread.currentThread().getName() + " finished the work...");
        System.out.println(Thread.currentThread().getName() + " is signaling the waiting workers...");
        startSignal.countDown();
        System.out.println(Thread.currentThread().getName() + " signaled the waiting workers...");
        System.out.println(Thread.currentThread().getName() + " waiting for the workers to finish...");
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " was signaled by the workers threads...");
        System.out.println(Thread.currentThread().getName() + " finished...");
    }

    private static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting to be signaled...");
        try {
            startSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " was signaled...");
        System.out.println(Thread.currentThread().getName() + " is doing the work...");
        sleep();
        System.out.println(Thread.currentThread().getName() + " finished the work...");
        doneSignal.countDown();
        System.out.println(Thread.currentThread().getName() + " signaled back to the main thread...");
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
