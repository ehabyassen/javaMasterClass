package com.oracle.concurrency;

import java.util.Random;

public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        Random random = new Random();
        String message = drop.take();
        while (!message.equals("DONE")) {
            System.out.println(message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
            message = drop.take();
        }
    }
}