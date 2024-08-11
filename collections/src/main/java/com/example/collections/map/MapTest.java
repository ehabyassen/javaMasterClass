package com.example.collections.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> data = new ConcurrentHashMap<>();
        data.put("n1", "Ehab");
        data.put("n2", "Aya");

        data.compute("n3", (k, v) -> args.length > 2 ? "Eslam" : "Mama");

        data.entrySet().forEach(e -> System.out.println(e.getKey() + "." + e.getValue()));
    }
}
