package com.collectionAPI.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(2, "Aya");
        map.put(1, "Ehab");
        map.put(3, "Eslam");

        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
