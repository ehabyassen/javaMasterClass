package com.lp.threadSafety.synchronizedCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());
        Thread t1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Thread t2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));
        Thread t3 = new Thread(() -> syncCollection.addAll(Arrays.asList(13, 14, 15, 16, 17)));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncCollection);
    }
}
