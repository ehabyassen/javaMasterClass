package com.oracle.concurrency;

public class SleepMessages {

    public static void main(String[] args) throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String info : importantInfo) {
            Thread.sleep(1000);
            System.out.println(info);
        }
    }
}
