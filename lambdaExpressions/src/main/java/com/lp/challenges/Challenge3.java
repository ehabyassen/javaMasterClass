package com.lp.challenges;

import java.util.Arrays;
import java.util.List;

public class Challenge3 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob"
        );
        names.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.length() > 1)
                .peek(System.out::println)
                .sorted(String::compareTo)
                .count();

    }
}
