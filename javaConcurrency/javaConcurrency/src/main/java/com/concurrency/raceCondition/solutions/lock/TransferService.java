package com.concurrency.raceCondition.solutions.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransferService {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Account sourceAccount = new Account(500);
        Account destAccount = new Account(500);

        System.out.println(Thread.currentThread().getName() + ": Source account balance: " + sourceAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ": Dest account balance: " + destAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ":" + "-".repeat(50));

        Thread t1 = new Thread(() -> transfer(300, sourceAccount, destAccount));

        Thread t2 = new Thread(() -> {
            sleep();
            transfer(400, sourceAccount, destAccount);
        });

        t1.start();
        t2.start();
    }

    private static void transfer(int amount, Account sourceAccount, Account destAccount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ": started...");
            if (sourceAccount.getBalance() < amount) {
                System.out.println(Thread.currentThread().getName() + ": Source account does not have sufficient balance to transfer " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + ": checked source account balance.");
                sleep();
                destAccount.setBalance(destAccount.getBalance() + amount);
                sleep();
                System.out.println(Thread.currentThread().getName() + ": incremented dest account.");
                sleep();
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                sleep();
                System.out.println(Thread.currentThread().getName() + ": decremented source account.");
                sleep();
                System.out.println(Thread.currentThread().getName() + ": Transferred [" + amount + "] from sourceAccount to destAccount.");
            }
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + ": Source account balance: " + sourceAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ": Dest account balance: " + destAccount.getBalance());
        System.out.println(Thread.currentThread().getName() + ":" + "-".repeat(50));
        System.out.println(Thread.currentThread().getName() + ": finished...");
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            //ignore e
        }
    }
}
