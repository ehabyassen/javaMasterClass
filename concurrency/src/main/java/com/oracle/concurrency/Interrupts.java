package com.oracle.concurrency;

public class Interrupts {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Greeter());
        t.start();
        Thread.sleep(3000);
        t.interrupt();

    }
}

class Greeter implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        for (int c = 0; c < 10; c++) {
            System.out.println("Hello " + i);
            i++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}