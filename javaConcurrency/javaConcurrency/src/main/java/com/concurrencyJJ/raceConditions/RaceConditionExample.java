package com.concurrencyJJ.raceConditions;

public class RaceConditionExample {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            run();
        }
    }

    private static void run() {
        Counter counter = new Counter();

        Thread thread1 = new Thread(getRunnable(counter), "Thread-1");
        Thread thread2 = new Thread(getRunnable(counter), "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("+".repeat(30));
    }

    private static Runnable getRunnable(Counter counter) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.inc();
            }
            System.out.println(Thread.currentThread().getName() + ": " + counter.getCount());
        };
    }
}

class Counter {

    private long count;

    public void inc() {
        synchronized (this) {
            count++;
        }
    }

    public long getCount() {
        return count;
    }
}
