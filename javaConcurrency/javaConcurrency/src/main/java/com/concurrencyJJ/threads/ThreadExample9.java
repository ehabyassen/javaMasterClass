package com.concurrencyJJ.threads;

public class ThreadExample9 {

    private static class StoppableRunnable implements Runnable {

        private boolean stopRequested;

        public synchronized boolean isStopRequested() {
            return stopRequested;
        }

        public synchronized void requestStop() {
            this.stopRequested = true;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running...");

            while (!isStopRequested()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": ...");
            }

            System.out.println(Thread.currentThread().getName() + " is stopped...");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        new Thread(stoppableRunnable).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stoppableRunnable.requestStop();
    }
}