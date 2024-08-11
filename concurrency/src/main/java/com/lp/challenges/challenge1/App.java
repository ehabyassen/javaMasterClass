package com.lp.challenges.challenge1;

import java.util.concurrent.locks.ReentrantLock;

public class App {

    private final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345-678", 1000.00, lock);

        Thread t1 = new Thread(() -> {
            account.deposit(300.00);
            account.withdraw(50.00);
        });

        Thread t2 = new Thread(() -> {
            account.deposit(203.75);
            account.withdraw(100);
        });

        t1.start();
        t2.start();
    }
}
