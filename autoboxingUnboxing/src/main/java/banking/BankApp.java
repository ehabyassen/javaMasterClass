package banking;

public class BankApp {

    public static void main(String[] args) {
        Customer eslam = new Customer("Eslam");
        Customer ehab = new Customer("Ehab");
        Customer aya = new Customer("Aya");

        Bank cib = new Bank("CIB");
        Branch x123 = new Branch("X123");
        cib.addBranch(x123);

        x123.addCustomer(eslam, 100_000.50);
        x123.makeTransaction(eslam, 50_000.50);

        cib.addCustomer(x123, ehab, 50_000.00);
        x123.makeTransaction(ehab, 25_000.00);
        x123.addCustomer(aya, 150_000.00);

        Branch x456 = new Branch("X456");
        cib.addBranch(x456);
        Customer mama = new Customer("Mama");
        x456.addCustomer(mama, 100_000);

        cib.makeTransaction(x123, mama, 25_000);

        cib.report("X123");
        cib.report("X456");

        cib.makeTransaction(new Branch("X789"), mama, 10_000);
    }
}
