package com.concurrency.threadSignaling.spurious;

public class SpuriousWakeupSignalGuard {

    private boolean wasSignaled = false;
    private final Object lock = new Object();

    public void doWait() throws InterruptedException {
        synchronized (lock) {
            while (!wasSignaled) {
                lock.wait();
            }
            wasSignaled = false;
        }
    }

    public void doNotify() {
        synchronized (lock) {
            wasSignaled = true;
            lock.notify();
        }
    }
}
