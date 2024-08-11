package com.lp.messages;

import java.util.Random;

public class Producer implements Runnable {

    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all king's men",
                "Couldn't put Humpty together again"};

        Random random = new Random();
        for (String currentMessage : messages) {
            message.write(currentMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {}
        }
        message.write("Finished");
    }
}
