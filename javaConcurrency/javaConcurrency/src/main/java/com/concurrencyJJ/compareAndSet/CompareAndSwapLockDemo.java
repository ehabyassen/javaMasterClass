package com.concurrencyJJ.compareAndSet;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwapLockDemo {

    public static void main(String[] args) {
        CompareAndSwapLock lock = new CompareAndSwapLock();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        Thread t2 = new Thread(lock::lock);
        Thread t3 = new Thread(lock::lock);

        t1.start();
        t2.start();
        t3.start();
    }
}

class CompareAndSwapLock {

    private AtomicBoolean locked = new AtomicBoolean(false);

    public void unlock() {
        System.out.println(Thread.currentThread().getName() + " attempting to unlock...");
        locked.set(false);
        System.out.println(Thread.currentThread().getName() + " successfully unlocked...");
    }

    public void lock() {
        while (!locked.compareAndSet(false, true)) {
            System.out.println(Thread.currentThread().getName() + " attempting to lock...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " successfully locked...");
    }
}