package com.lp;

public class BankAccount {

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;
    private String accountNumber;
    private double balance;
    private int accountType;

    public BankAccount(String accountNumber, double balance, int accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) {
        if (amount > 500.00 && !branch) {
            throw new IllegalStateException("Withdrawal of amount larger than 500 is not allowed out of a branch");
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return accountType == CHECKING;
    }
}
