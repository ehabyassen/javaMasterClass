package com.concurrencyJJ.compareAndSet;

public class ProblematicLockDemo {

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

class Lock {

    private volatile boolean locked = false;

    public void unlock() {
        System.out.println(Thread.currentThread().getName() + " attempting to unlock...");
        locked = false;
        System.out.println(Thread.currentThread().getName() + " successfully unlocked...");
    }

    public void lock() {
        while (locked) {
            System.out.println(Thread.currentThread().getName() + " attempting to lock...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked = true;
        System.out.println(Thread.currentThread().getName() + " successfully locked...");
    }
}