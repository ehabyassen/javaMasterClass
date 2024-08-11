package com.lp.messages;

import java.util.Random;

public class Consumer implements Runnable {

    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }


    @Override
    public void run() {
        Random random = new Random();
        String currentMessage = message.read();
        while (!currentMessage.equals("Finished")) {
            System.out.println(currentMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {}
            currentMessage = message.read();
        }
    }
}

