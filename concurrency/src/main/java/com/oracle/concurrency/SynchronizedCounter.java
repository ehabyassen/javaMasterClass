package com.oracle.concurrency;

public class SynchronizedCounter {

    private int c;

    public synchronized void increment(){
        c++;
    }

    public synchronized void decrement(){
        c--;
    }

    public synchronized int getC() {
        return c;
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " retrieve 'c': " + counter.getC());
                System.out.println(Thread.currentThread().getName() + " increment 'c'"); counter.increment();
                System.out.println(Thread.currentThread().getName() + " retrieve 'c': " + counter.getC());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("\t\t" + Thread.currentThread().getName() + " retrieve 'c': " + counter.getC());
                System.out.println("\t\t" + Thread.currentThread().getName() + " decrement 'c'"); counter.decrement();
                System.out.println("\t\t" + Thread.currentThread().getName() + " retrieve 'c': " + counter.getC());
            }
        });

        t1.start();
        t2.start();
    }
}
