package com.lp;

import static com.lp.ThreadColor.*;

public class Counter {

    public static void main(String[] args) {
        CountDown countDown = new CountDown();

        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread-1");

        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}

class CountDown {

    private int i;
    public void doCountDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread-1" -> color = ANSI_CYAN;
            case "Thread-2" -> color = ANSI_PURPLE;
            default -> color = ANSI_GREEN;
        }

        synchronized (this) {
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
            }
        }
    }
}

class CountDownThread extends Thread {
    private final CountDown countDown;

    public CountDownThread(CountDown countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        countDown.doCountDown();
    }
}
