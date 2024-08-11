package com.concurrency.intro;

import java.util.Scanner;

public class BlockingInputReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Thread.currentThread().getName() + ": Enter your name: ");
        //next() blocks until input is read
        String name = scanner.next();
        System.out.println(Thread.currentThread().getName() + ": Hello, " + name);
        System.out.println(Thread.currentThread().getName() + ": Will not appear until next returns and greeting is displayed.");
    }
}
