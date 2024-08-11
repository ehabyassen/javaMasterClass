package com.concurrency.threadSignaling.missedSignals;

public class SignalCarrier {

    public void doWait() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void doNotify() {
        synchronized (this) {
            notify();
        }
    }

    public void doNotifyAll() {
        synchronized (this) {
            notifyAll();
        }
    }
}
