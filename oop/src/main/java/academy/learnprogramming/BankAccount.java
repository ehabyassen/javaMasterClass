package academy.learnprogramming;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;

    public BankAccount(String accountNumber, String customerName) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successful deposit. Balance is: " + balance);
        } else {
            System.out.println("Amount deposited can not be negative.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Successful withdrawal. Balance is: " + balance);
        } else {
            System.out.println("There is no sufficient balance for the withdrawal. Balance is: " + balance);
        }
    }
}
