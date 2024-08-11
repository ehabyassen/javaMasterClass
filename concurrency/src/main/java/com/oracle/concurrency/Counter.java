package com.oracle.concurrency;

public class Counter {

    private int c;

    public void increment(){
        c++;
    }

    public void decrement(){
        c--;
    }

    public int getC() {
        return c;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

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
