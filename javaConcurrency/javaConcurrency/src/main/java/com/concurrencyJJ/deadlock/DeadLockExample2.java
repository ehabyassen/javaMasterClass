package com.concurrencyJJ.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample2 {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started...");
            lock1.lock();
            System.out.println("Thread-1 acquired lock-1...");

            sleep();

            System.out.println("Thread-1 trying to acquire lock-2...");
            lock2.lock();

            System.out.println("Thread-1 is executing the critical section...");
            lock2.unlock();
            lock1.unlock();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread-2 started...");
            lock1.lock();
            System.out.println("Thread-2 acquired lock-1...");
            System.out.println("Thread-2 trying to acquire lock-2...");
            lock2.lock();

            System.out.println("Thread-2 is executing the critical section...");
            lock2.unlock();
            lock1.unlock();
        });

        t1.start();
        t2.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}