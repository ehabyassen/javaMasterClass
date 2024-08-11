package com.oracle.concurrency;

public class HappensBefore {

    private int counter = 0;

    public void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws InterruptedException {
        HappensBefore hb = new HappensBefore();
        hb.increment();
        Thread t = new Thread(() -> {
            System.out.println(hb.getCounter());
            hb.increment();
            hb.increment();
        });
        t.start();
        t.join();
        System.out.println(hb.getCounter());
    }
}
