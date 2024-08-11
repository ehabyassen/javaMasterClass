package com.concurrencyJJ.locks;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class SafelyUnlockExample {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        AtomicBoolean canStart = new AtomicBoolean(false);

        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started...");
            System.out.println("Thread-1 will sleep for 1 nano seconds...");
            sleep();
            System.out.println("Thread-1 woke up...");
            try {
                lock.lock();
                System.out.println("Thread-1 acquired the lock...");
                canStart.set(true);
                foo();
            } finally {
                lock.unlock();
                System.out.println("Thread-1 released the lock...");
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            while (!canStart.get()) {
                System.out.println("Thread-2 waiting for the flag to start...");
                Thread.onSpinWait();
            }
            System.out.println("Thread-2 waiting for the lock to be released...");
            lock.lock();
            System.out.println("Thread-2 acquired the lock...");
            System.out.println("Hello from " + Thread.currentThread().getName());
            lock.unlock();
            System.out.println("Thread-2 released the lock...");
        }, "Thread-2");

        t1.start();
        t2.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(0, 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void foo() {
        System.out.println("Hello from " + Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int input = sc.nextInt();
        if (input == 1) {
           throw new RuntimeException("Expected...");
        }
    }
}
