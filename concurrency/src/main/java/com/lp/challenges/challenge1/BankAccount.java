package com.lp.challenges.challenge1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private ReentrantLock lock;

    public BankAccount(String accountNumber, double initialBalance, ReentrantLock lock) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = lock;
    }

    public void deposit(double amount) {
        boolean status = false;

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    getBalance();
                    System.out.println(Thread.currentThread().getName() + ": depositing " + amount);
                    balance += amount;
                    getBalance();
                    status = true;
                    System.out.println("-".repeat(20));
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
        }

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    getBalance();
                    System.out.println(Thread.currentThread().getName() + ": withdrawing " + amount);
                    balance -= amount;
                    getBalance();
                    status = true;
                    System.out.println("-".repeat(20));
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
        }

        System.out.println("Transaction status = " + status);
    }

    public double getBalance() {
        System.out.println(Thread.currentThread().getName() + ": Balance is " + balance);
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account Number: " + accountNumber);
    }
}
