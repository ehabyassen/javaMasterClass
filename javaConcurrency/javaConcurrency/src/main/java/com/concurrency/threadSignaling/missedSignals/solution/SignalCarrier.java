package com.concurrency.threadSignaling.missedSignals.solution;

public class SignalCarrier {

    private int threadsWaiting = 0;
    private int signals = 0;

    public void doWait() {
        synchronized (this) {
            if (signals > 0) {
                signals--;
                return;
            }
            try {
                threadsWaiting++;
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void doNotify() {
        synchronized (this) {
            if (threadsWaiting == 0) {
                signals++;
                return;
            }
            notify();
        }
    }

    public void doNotifyAll() {
        synchronized (this) {
            if (threadsWaiting == 0) {
                signals++;
                return;
            }
            notifyAll();
        }
    }
}
