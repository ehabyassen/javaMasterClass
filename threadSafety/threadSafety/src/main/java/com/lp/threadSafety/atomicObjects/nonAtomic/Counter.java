package com.lp.threadSafety.atomicObjects.nonAtomic;

public class Counter {

    private int value = 0;

    public void incrementCounter() {
        value += 1;
    }

    public int getCounter() {
        return value;
    }
}
