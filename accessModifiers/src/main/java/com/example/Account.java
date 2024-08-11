package com.example;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String name;
    private int balance;
    private List<Integer> transactions;

    public Account(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            balance += amount;
            System.out.println(amount + " deposited. Balance is: " + balance);
        } else {
            System.out.println("Deposit can not be negative amount.");
        }
    }

    public void withdrawal(int amount) {
        if (balance - amount < 0) {
            System.out.println("Balance is not enough for withdrawal. Max to withdraw is: " + balance);
        } else {
            balance -= amount;
            transactions.add(amount * -1);
            System.out.println(amount + " withdrawn. Balance is: " + balance);
        }
    }

    public void calculateBalance() {
        System.out.println("Balance is: " + transactions.stream().reduce(0, Integer::sum));
    }
}
