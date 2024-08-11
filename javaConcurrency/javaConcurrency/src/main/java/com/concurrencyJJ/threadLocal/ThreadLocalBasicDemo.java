package com.concurrencyJJ.threadLocal;

public class ThreadLocalBasicDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            threadLocal.set("Value-1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            threadLocal.set("Value-2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
