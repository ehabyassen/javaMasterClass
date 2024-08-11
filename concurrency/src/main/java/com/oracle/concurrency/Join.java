package com.oracle.concurrency;

public class Join {

    private static Thread t1;
    private static Thread t2;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            t2.start();
            System.out.println("t1 is executing");
            try {

                t2.join();
            } catch (InterruptedException e) {
                System.out.println("t1 is interrupted");
            }
        });

        t2 = new Thread(() -> {
            System.out.println("t2 is executing");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("t2 is interrupted");
            }
        });

        t1.start();
        t1.interrupt();

    }
}