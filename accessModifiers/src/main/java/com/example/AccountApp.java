package com.example;

public class AccountApp {

    public static void main(String[] args) {
        Account account = new Account("Ehab");
        account.deposit(1000);
        account.withdrawal(500);
        account.withdrawal(700);
        account.deposit(300);
        account.calculateBalance();

        System.out.println(account.getBalance());
        account.calculateBalance();

        System.out.println(account.getBalance());
        account.calculateBalance();
    }
}
