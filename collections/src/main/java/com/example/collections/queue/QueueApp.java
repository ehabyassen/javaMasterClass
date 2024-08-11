package com.example.collections.queue;

import java.util.*;

public class QueueApp {

    public static void main(String[] args) {

        List<String> names = new LinkedList<>();

        names.add("N1");
        names.add("N3");
        names.add("N4");
        names.add("N2");

        System.out.println(names);

        Queue<String> strings = new PriorityQueue<>(names);
        List<String> ordered = new ArrayList<>();
        while (!strings.isEmpty()) {
            ordered.add(strings.remove());
        }

        System.out.println(ordered);
    }
}
