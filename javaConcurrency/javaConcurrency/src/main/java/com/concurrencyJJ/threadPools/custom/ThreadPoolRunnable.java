package com.concurrencyJJ.threadPools.custom;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable {

    private Thread thread;
    private final BlockingQueue<Runnable> taskQueue;
    private boolean isStopped;

    public ThreadPoolRunnable(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        thread = Thread.currentThread();
        while (!isStopped) {
            try {
                taskQueue.take().run();
            } catch (InterruptedException e) {
                //keep the thread pool alive
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
