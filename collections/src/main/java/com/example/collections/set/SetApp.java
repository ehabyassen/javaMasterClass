package com.example.collections.set;

import java.util.*;

public class SetApp {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ehab");
        names.add("Ehab");
        names.add("Eslam");
        names.add("Aya");
        names.add("Eslam");

        System.out.println(names);

        Set<String> strings = new HashSet<>(names);

        Set<String> lhs = new TreeSet<>(names);
        System.out.println(lhs);



    }
}
