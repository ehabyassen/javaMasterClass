package com.concurrencyJJ.volatileKW;

public class Demo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter.inc();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                counter.inc();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCount());
    }
}
