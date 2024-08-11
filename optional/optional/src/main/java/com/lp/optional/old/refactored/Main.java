package com.lp.optional.old.refactored;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    private static Optional<String> getEmpty() {
        return Optional.empty();
    }

    private static Optional<String> getHello() {
        return Optional.of("hello");
    }

    private static Optional<String> getBye() {
        return Optional.of("bye");
    }

    private static Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }
}
