package com.collectionAPI.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NonThreadSafeMapExample {

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        List<Integer> sum = parallelSum100();
        long t2 = System.currentTimeMillis();
        System.out.println("Elapsed: " + (t2 - t1));
        System.out.println(sum);
    }

    private static List<Integer> parallelSum100() throws InterruptedException {
        List<Integer> sum = new ArrayList<>();
        Map<String, Integer> map;
        for (int i = 0; i < 10000; i++) {
            map = new HashMap<>();
            map.put("test", 0);
            ExecutorService service = Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                Map<String, Integer> finalMap = map;
                service.execute(() -> {
                    for (int k = 0; k < 10; k++) {
                        finalMap.computeIfPresent("test", (key, value) -> value + 1);
                    }
                });
            }
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            sum.add(map.get("test"));
        }
        return sum;
    }
}
