package com.concurrencyJJ.issues.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

    public static void main(String[] args) {
        Lock sharedLock = new ReentrantLock();

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " trying to acquire the lock...");
                sharedLock.lock();
                System.out.println(Thread.currentThread().getName() + " acquired the lock...");
                sharedLock.unlock();
                System.out.println(Thread.currentThread().getName() + " released the lock...");
                if (sharedLock.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " Reacquired the lock...");
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to reacquire the lock...");
                }
            }
        };

        new Thread(runnable, "Thread-1").start();
        new Thread(runnable, "Thread-2").start();
    }
}
