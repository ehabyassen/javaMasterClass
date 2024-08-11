package com.example.collections.set;

import java.util.*;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new TreeSet<>();
        Set<Integer> cubes = new TreeSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        squares.forEach(s -> System.out.print(s + ", "));
        System.out.println();
        cubes.forEach(c -> System.out.print(c + ", "));
        System.out.println();

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements.");

        System.out.println("Common elements:");
        Set<Integer> common = new TreeSet<>(cubes);
        common.retainAll(squares);
        common.forEach(c -> System.out.println(c + " is the square of " + Math.sqrt(c) + " and the cube of " + Math.cbrt(c)));

        String sentence = "one day in the year of the fox";
        String[] wordsArray = sentence.split(" ");
        Set<String> words = new HashSet<>(Arrays.asList(wordsArray));

        System.out.println(words);


        Set<String> nature = new HashSet<>(Arrays.asList("all nature is but art unknown to thee".split(" ")));
        Set<String> divine = new HashSet<>(Arrays.asList("to err is human to forgive divine".split(" ")));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        System.out.println(diff1);

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        System.out.println(diff2);


        System.out.println("nature ret divine:");
        Set<String> ret1 = new HashSet<>(nature);
        ret1.retainAll(divine);
        System.out.println(ret1);

        System.out.println("divine ret nature:");
        Set<String> ret2 = new HashSet<>(divine);
        ret2.retainAll(nature);
        System.out.println(ret2);

        Set<String> union2 = new HashSet<>(nature);
        union2.addAll(divine);
        union2.removeAll(ret2);
        System.out.println(union2);
    }
}
