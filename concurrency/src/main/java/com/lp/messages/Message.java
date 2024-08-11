package com.lp.messages;

public class Message {

    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) { //as long as message is empty, wait until there is a message to read
            //wait or do something
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) { //wait as long as message is not empty, wait to avoid overwriting the message
            //wait or do something
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
