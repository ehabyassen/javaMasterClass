package com.lp.threadSafety.atomicObjects.nonAtomic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            test(new Counter());
        }
    }

    private static void test(Counter counter) {
        List<Thread> threads = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(random.nextLong(600));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.incrementCounter();
                try {
                    Thread.sleep(random.nextLong(600));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads.add(t);
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Value: " + counter.getCounter());
    }
}
