package com.example.collections.map.baeldung.HashTable;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args){
        Map<String, String> names = new HashMap<>();
        names.put("n1", "Ehab");
        names.put("n2", null);
        names.put("n3", null);
        names.put(null, "Eslam");

        names.forEach((key, value) -> System.out.println(key + "." + value));
        System.out.println("-".repeat(30));

        names.remove("n2");

        int i = 3;
        names.computeIfAbsent("n2", s -> null);

        names.forEach((key, value) -> System.out.println(key + "." + value));
        System.out.println("-".repeat(30));
    }

    public static int getNum() {
        return 4;
    }
}
