package com.concurrencyJJ.threadLocal;

public class ThreadLocalInitialValueDemo {

    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal1 = ThreadLocal.withInitial(Object::new);
        ThreadLocal<Object> threadLocal2 = ThreadLocal.withInitial(Object::new);


        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal2.get());
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal1.get());
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal2.get());
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
