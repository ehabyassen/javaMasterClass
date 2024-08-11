package com.lp.threadSafety.threadLocalFields.threadClassesWithTheirLocalFields;

import java.util.Arrays;
import java.util.List;

public class ThreadB extends Thread {

    private final List<String> names = Arrays.asList("Ehab", "Aya", "Eslam");

    @Override
    public void run() {
        System.out.println(String.join("-", names));
    }
}
