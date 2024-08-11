package banking;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Double> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
