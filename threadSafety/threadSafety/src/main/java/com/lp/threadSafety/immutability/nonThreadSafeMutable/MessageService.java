package com.lp.threadSafety.immutability.nonThreadSafeMutable;

public class MessageService {

    private int value;

    public MessageService(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
