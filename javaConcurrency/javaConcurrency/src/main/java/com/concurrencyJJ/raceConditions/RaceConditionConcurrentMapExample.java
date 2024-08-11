package com.concurrencyJJ.raceConditions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RaceConditionConcurrentMapExample {

    public static void main(String[] args) {
        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (sharedMap) {
                    if (sharedMap.containsKey("key")) {
                        //race condition occurs between these two lines
                        String val = sharedMap.remove("key");
                        if (val == null) {
                            System.out.println("Iteration: " + i + ": Value for 'key' was null!");
                        }
                    } else {
                        sharedMap.put("key", "value");
                    }
                }
            }
        };
    }
}
