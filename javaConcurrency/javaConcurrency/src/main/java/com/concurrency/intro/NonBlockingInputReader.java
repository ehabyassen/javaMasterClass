package com.concurrency.intro;

import java.util.Scanner;

public class NonBlockingInputReader {

    public static void main(String[] args) {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print(Thread.currentThread().getName() + ": Enter your name: ");
            String name = scanner.next();
            System.out.println(Thread.currentThread().getName() + ": Hello, " + name);
        }).start();

        System.out.println(Thread.currentThread().getName() +
                ": Should be displayed and will not wait for the input/greeting process.");
    }
}
