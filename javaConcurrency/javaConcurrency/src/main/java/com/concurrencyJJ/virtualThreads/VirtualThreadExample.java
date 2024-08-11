package com.concurrencyJJ.virtualThreads;

public class VirtualThreadExample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " Running");
            }
        };

        Thread vThread1 = Thread.ofVirtual().unstarted(runnable);

        vThread1.start();

        try {
            vThread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
