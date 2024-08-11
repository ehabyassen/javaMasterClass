package com.concurrencyJJ.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("Thread-1 acquired the lock...");
                System.out.println("Thread-1 will sleep for 2 seconds...");
                sleep(2000);
                System.out.println("Thread-1 woke up...");
            } finally {
                lock.unlock();
                System.out.println("Thread-1 released the lock...");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                sleep(1000);
                lock.lock();
                System.out.println("Thread-2 acquired the lock...");
                System.out.println("Thread-2 will sleep for 2 seconds...");
                sleep(2000);
                System.out.println("Thread-2 woke up...");
            } finally {
                lock.unlock();
                System.out.println("Thread-2 released the lock...");
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
