package com.concurrencyJJ.threadLocal;

public class InheritableThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            threadLocal.set("Val-1");
            inheritableThreadLocal.set("Val-2");

            System.out.println(Thread.currentThread().getName() + ": ThreadLocal Value: " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ": InheritableThreadLocal Value: " + inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": ThreadLocal Value: " + threadLocal.get());
                System.out.println(Thread.currentThread().getName() + ": InheritableThreadLocal Value: " + inheritableThreadLocal.get());
            }, "Child Thread");

            childThread.start();
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": ThreadLocal Value: " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ": InheritableThreadLocal Value: " + inheritableThreadLocal.get());
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
