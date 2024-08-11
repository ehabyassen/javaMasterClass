package com.concurrency.threadSignaling.producerConsumer;

public class Demo {

    public static void main(String[] args) {
        DataCarrier carrier = new DataCarrier();
        Thread producerThread = new Thread(new Producer(carrier), "Producer Thread");
        Thread consumerThread = new Thread(new Consumer(carrier), "Consumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}
