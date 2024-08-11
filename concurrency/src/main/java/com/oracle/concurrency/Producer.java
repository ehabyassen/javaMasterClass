package com.oracle.concurrency;

import java.util.Random;

public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }


    @Override
    public void run() {
        String[] messages = {"A", "B", "C", "D"};
        Random random = new Random();
        for (String message : messages) {
            drop.put(message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        drop.put("DONE");
    }
}
