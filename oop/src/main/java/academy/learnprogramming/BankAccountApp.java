package academy.learnprogramming;

public class BankAccountApp {

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("1001", "Ehab Ahmed");
        acc1.setEmailAddress("ea@gmail.com");
        acc1.setPhoneNumber("010234567889");
        acc1.setBalance(1_000_000);

        acc1.deposit(30_000);
        acc1.withdraw(50_000_000);
        acc1.withdraw(50_000);
    }
}
