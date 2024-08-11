package com.lp.deadlock;

import static com.lp.producerConsumer.ThreadColor.ANSI_BLUE;
import static com.lp.producerConsumer.ThreadColor.ANSI_GREEN;

public class DeadLock1 {

    public static void main(String[] args) {
        /**
         * What is a deadlock? When two or more thread are blocked on locks. So for example thread 1 holding lock 1
         * and trying to acquire lock 2 while thread 2 holding lock 2 and trying to acquire lock 1.
         */

        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(ANSI_BLUE + "Thread 1 acquired lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(ANSI_BLUE + "Thread 1 was interrupted.");
                }
                synchronized (lock2) {
                    System.out.println(ANSI_BLUE + "Thread 1 acquired lock 1 and lock 2");
                }
                System.out.println(ANSI_BLUE + "Thread 1 released lock 2");
            }
            System.out.println(ANSI_BLUE + "Thread 1 released lock 1");
        }).start();

        new Thread(() -> {
            System.out.println(ANSI_GREEN + "Thread 2 is waiting for lock 1");
            synchronized (lock1) {
                System.out.println(ANSI_GREEN + "Thread 2 acquired lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + "Thread 2 was interrupted.");
                }
                synchronized (lock2) {
                    System.out.println(ANSI_GREEN + "Thread 2 acquired lock 2 and lock 1");
                }
                System.out.println(ANSI_GREEN + "Thread 2 released lock 2");
            }
            System.out.println(ANSI_GREEN + "Thread 2 released lock 1");
        }).start();
    }
}
