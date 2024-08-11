package com.lp.threadSafety.threadLocalFields.threadClassesWithTheirLocalFields;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ThreadA extends Thread {

    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    @Override
    public void run() {
        System.out.println(numbers.stream().map(String::valueOf).collect(joining("-")));
    }
}
