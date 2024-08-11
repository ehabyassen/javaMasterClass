package com.lp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g46",
                "I26", "I17", "I29",
                "O71");


        someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(num -> num.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("-".repeat(40));

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        System.out.println("-".repeat(40));

        List<String> sortedGNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)
                .filter(num -> num.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedGNumbers);
    }
}
