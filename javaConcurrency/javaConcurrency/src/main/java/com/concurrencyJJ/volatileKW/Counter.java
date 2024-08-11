package com.concurrencyJJ.volatileKW;

public class Counter {

    private int count;

    public void inc() {
        if (count == 10) {
            return;
        }
        if (Thread.currentThread().getName().contains("1")) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
