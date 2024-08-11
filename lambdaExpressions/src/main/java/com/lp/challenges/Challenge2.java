package com.lp.challenges;

import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge2 {

    public static void main(String[] args) {
        Function<String, String> mapper = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) returnVal.append(source.charAt(i));
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharacter(mapper, "1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java!";
        System.out.println(iLoveJava.get());
    }

    private static String everySecondCharacter(Function<String, String> mappingFunction, String input) {
        return mappingFunction.apply(input);
    }
}
