package com.concurrencyJJ.threadLocal;

public class ThreadLocalRemovalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            threadLocal.set("Value-1");
            sleep(2000);
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            threadLocal.set("Value-2");
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }, "Thread-2");

        t1.start();
        t2.start();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
