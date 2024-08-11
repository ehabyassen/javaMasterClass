package com.concurrency.threadLifeCycle;

public class Blocked {

    public static void main(String[] args) throws InterruptedException {
        DemoBlockedRunnable demo = new DemoBlockedRunnable();
        Thread t1 = new Thread(demo);
        Thread t2 = new Thread(demo);

        t1.start();
        t2.start();

        System.out.println(t1.getName() + " is " + t1.getState());
        System.out.println(t2.getName() + " is " + t2.getState());
        System.exit(0);
    }
}

class DemoBlockedRunnable implements Runnable {

    @Override
    public void run() {
        commonResource();
    }

    private synchronized void commonResource() {
        while (true) {
            //do nothing
        }
    }
}
