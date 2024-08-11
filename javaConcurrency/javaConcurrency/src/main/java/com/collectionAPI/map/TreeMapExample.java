package com.collectionAPI.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>(   );

        map.put(2, "Ehab");
        map.put(3, "Aya");
        map.put(1, "Eslam");

        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
