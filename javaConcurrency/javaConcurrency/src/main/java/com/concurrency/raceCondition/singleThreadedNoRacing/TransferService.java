package com.concurrency.raceCondition.singleThreadedNoRacing;

public class TransferService {

    public static void main(String[] args) {
        Account sourceAccount = new Account(500);
        Account destAccount = new Account(500);

        System.out.println("Source account balance: " + sourceAccount.getBalance());
        System.out.println("Dest account balance: " + destAccount.getBalance());
        System.out.println("-".repeat(50));

        transfer(300, sourceAccount, destAccount);

        System.out.println("Source account balance: " + sourceAccount.getBalance());
        System.out.println("Dest account balance: " + destAccount.getBalance());
        System.out.println("-".repeat(50));

        transfer(400, sourceAccount, destAccount);

        System.out.println("Source account balance: " + sourceAccount.getBalance());
        System.out.println("Dest account balance: " + destAccount.getBalance());
        System.out.println("-".repeat(50));
    }

    private static void transfer(int amount, Account sourceAccount, Account destAccount) {
        if (sourceAccount.getBalance() < amount) {
            System.out.println("Source account does not have sufficient balance to transfer " + amount);
        } else {
            destAccount.setBalance(destAccount.getBalance() + amount);
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            System.out.println("Transferred [" + amount + "] from sourceAccount to destAccount.");
        }
    }
}
