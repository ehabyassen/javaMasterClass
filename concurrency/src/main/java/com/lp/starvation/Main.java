package com.lp.starvation;

import com.lp.producerConsumer.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Prioriy 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Prioriy 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Prioriy 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_BLACK), "Prioriy 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Prioriy 2");

        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        //Starvation happens when a long-running thread causes other threads to block.
    }

    private static class Worker implements Runnable {

        private int counter = 1;
        private final String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: Count = %d%n", Thread.currentThread().getName(), counter++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
