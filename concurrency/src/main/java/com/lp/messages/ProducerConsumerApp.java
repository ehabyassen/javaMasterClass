package com.lp.messages;

public class ProducerConsumerApp {

    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }
}
