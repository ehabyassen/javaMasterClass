package com.concurrencyJJ.issues.deadlock;

public class DeadlockExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (String.class) {
                System.out.println(Thread.currentThread().getName() + " acquired String class lock...");
                System.out.println(Thread.currentThread().getName() + " trying to acquire Integer class lock...");
                synchronized (Integer.class) {
                    System.out.println(Thread.currentThread().getName() + " acquired Integer class lock...");
                }
                System.out.println(Thread.currentThread().getName() + " released Integer class lock...");
            }
            System.out.println(Thread.currentThread().getName() + " released String class lock...");
        });

        Thread t2 = new Thread(() -> {
            synchronized (Integer.class) {
                System.out.println(Thread.currentThread().getName() + " acquired Integer class lock...");
                System.out.println(Thread.currentThread().getName() + " trying to acquire String class lock...");
                synchronized (String.class) {
                    System.out.println(Thread.currentThread().getName() + " acquired String class lock...");
                }
                System.out.println(Thread.currentThread().getName() + " released String class lock...");
            }
            System.out.println(Thread.currentThread().getName() + " released Integer class lock...");
        });

        t1.start();
        t2.start();
    }
}
