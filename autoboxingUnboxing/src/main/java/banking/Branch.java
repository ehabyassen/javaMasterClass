package banking;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private String number;
    private List<Customer> customers;

    public Branch(String number) {
        this.number = number;
        customers = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer, double initialTransaction) {
        if (customers.stream().noneMatch(c -> c.getName().equals(customer.getName()))) {
            customer.addTransaction(initialTransaction);
            customers.add(customer);
            System.out.println("Added a new customer.");
        } else {
            System.out.println("Customer exists already.");
        }
    }

    public void makeTransaction(Customer customer, double transaction) {
        customers.stream()
                .filter(c -> c.getName().equals(customer.getName()))
                .findFirst().ifPresent(res -> res.addTransaction(transaction));
    }
}
