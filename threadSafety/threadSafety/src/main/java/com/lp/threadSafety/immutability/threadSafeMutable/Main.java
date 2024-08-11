package com.lp.threadSafety.immutability.threadSafeMutable;

public class Main {

    public static void main(String[] args) {
        ThreadSafeMutableMessageService service = new ThreadSafeMutableMessageService(5);

        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName() + ": " + service.getValue()));
            t.start();
        }
    }
}
