package com.example.collections.map.exercise;

import java.util.*;

public class App {

    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        locations.put(0, new Location(0, "You are setting .... learning java", null));
        locations.put(1, new Location(1, "Your are standing .... before small bridge", Map.of("W", 2,
                "E", 3,
                "S", 4,
                "N", 5)));
        locations.put(2, new Location(2, "You are at the top of a hill", Map.of("N", 5)));
        locations.put(3, new Location(3, "You are inside a building .... small spring", Map.of("W", 1)));
        locations.put(4, new Location(4, "You are in a valley beside a stream", Map.of("N", 1, "W", 2)));
        locations.put(5, new Location(5, "You are in the forest", Map.of("W", 2, "S", 1)));

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exists = locations.get(loc).getExits();
            System.out.println("available exits:");
            exists.keySet().forEach(k -> System.out.print(k + ", "));
            System.out.println();

            String inst = sc.nextLine().toUpperCase();
            String dir = Arrays.stream(inst.split(" "))
                    .map(w -> w.substring(0, 1))
                    .filter(w -> List.of("Q", "N", "S", "E", "W").contains(w))
                    .findFirst().orElse("Z");
            if (exists.containsKey(dir)) {
                loc = exists.get(dir);
            } else {
                System.out.println("you can not go in this direction.");
            }

            if (!locations.containsKey(loc)) {
                System.out.println("you can not go there.");
                loc = 1;
            }
        }
    }
}
