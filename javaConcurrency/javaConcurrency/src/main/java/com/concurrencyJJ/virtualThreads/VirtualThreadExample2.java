package com.concurrencyJJ.virtualThreads;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadExample2 {

    public static void main(String[] args) {
        List<Thread> vThreads = new ArrayList<>();
        int vThreadsCount = 100_000;

        for (int i = 0; i < vThreadsCount; i++) {
            int index = i;
            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for (int j = 0; j < 10; j++) {
                    result *= (j + 1);
                }
                System.out.println("Result[" + index + "]: " + result);
            });
            vThreads.add(vThread);
        }

        vThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
