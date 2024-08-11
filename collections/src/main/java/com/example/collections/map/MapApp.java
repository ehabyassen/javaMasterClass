package com.example.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapApp {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A high level oop language");
        languages.put("PYthon", "interpreted high level dynamic oop language");
        languages.put("Algol", "an arithmatic language");
        System.out.println(languages.put("BASIC", "All purpose symbolic instruction code"));;
        System.out.println(languages.put("BASIC", "All purpose symbolic instruction code 2"));;

        System.out.println(languages.get("BASIC"));

        System.out.println("-".repeat(30));

        Set<String> keys = languages.keySet();
        keys.forEach(k -> System.out.println(k + " - " + languages.get(k)));

        System.out.println("-".repeat(30));

        languages.remove("BASIC", "");

        languages.keySet().forEach(k -> System.out.println(k + " - " + languages.get(k)));

        languages.replace("", "");
    }

}
