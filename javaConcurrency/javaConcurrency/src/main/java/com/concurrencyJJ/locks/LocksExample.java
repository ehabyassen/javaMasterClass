package com.concurrencyJJ.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> lockSleepUnLock(lock);

        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");
        Thread t3 = new Thread(runnable, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void lockSleepUnLock(Lock lock) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " holds the lock...");
            doSleep();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock...");
        }
    }

    private static void doSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
