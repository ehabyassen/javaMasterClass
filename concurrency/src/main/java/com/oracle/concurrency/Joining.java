package com.oracle.concurrency;

public class Joining {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runner());
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Master " + i);
            Thread.sleep(100);
            if (i == 4) {
                t.join();
            }
        }
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}