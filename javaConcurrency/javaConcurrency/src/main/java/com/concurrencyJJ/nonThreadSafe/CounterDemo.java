package com.concurrencyJJ.nonThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterDemo {

    public static void main(String[] args) {
        Counter counter = new Counter(0);

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.inc();
            }
            System.out.println(Thread.currentThread().getName() + ": " + counter.getCount());
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Counter {

    private final AtomicInteger counter;
    public Counter(int count) {
        counter = new AtomicInteger(count);
    }

    public void inc() {
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
