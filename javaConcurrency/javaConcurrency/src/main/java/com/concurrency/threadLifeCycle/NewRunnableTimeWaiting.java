package com.concurrency.threadLifeCycle;

import java.util.List;

import static java.lang.Thread.State.NEW;
import static java.lang.Thread.State.TERMINATED;
import static java.lang.Thread.sleep;

public class NewRunnableTimeWaiting {

    public static void main(String[] args) {
        new NewRunnableTimeWaiting().foo();
    }

    public void foo() {
        Runnable runnable = () -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                //ignore e
            }
            System.out.println(Thread.currentThread().getName() + ": Hello");
        };

        Thread t = new Thread(runnable);

        System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " status is " + t.getState());

        t.start();

        while (!List.of(NEW, TERMINATED).contains(t.getState())) {
            System.out.println(Thread.currentThread().getName() + ": " + t.getName() + " status is " + t.getState());
            try {
                synchronized (this) {
                    wait(200);
                }
            } catch (InterruptedException e) {
                //ignore e
            }
        }
    }
}
