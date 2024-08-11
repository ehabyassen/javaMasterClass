package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    private String name;

    private List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public void addBranch(Branch newBranch) {
        if (branches.stream().noneMatch(b -> b.getNumber().equals(newBranch.getNumber()))) {
            branches.add(newBranch);
            System.out.println("Added a new branch");
        } else {
            System.out.println("Branch exists already.");
        }
    }

    public void addCustomer(Branch branch, Customer customer, double initialTransaction) {
        if (branches.stream().noneMatch(b -> b.getNumber().equals(branch.getNumber()))) {
            System.out.println("Branch not found");
        } else {
            branches.stream()
                    .filter(b -> b.getNumber().equals(branch.getNumber()))
                    .findFirst().ifPresent(b -> b.addCustomer(customer, initialTransaction));
        }
    }

    public void makeTransaction(Branch branch, Customer customer, double transaction) {
        if (branches.stream().noneMatch(b -> b.getNumber().equals(branch.getNumber()))) {
            System.out.println("Branch not found");
        } else {
            branches.stream()
                    .filter(b -> b.getNumber().equals(branch.getNumber()))
                    .findFirst().ifPresent(b -> b.makeTransaction(customer, transaction));
        }
    }

    public void report(String branchNumber) {
        branches.stream()
                .filter(b -> b.getNumber().equals(branchNumber))
                .findFirst().ifPresent(b -> {
                    String res = b.getCustomers().stream().map(Customer::toString).collect(Collectors.joining("\n", "[", "]"));
                    System.out.println(res);
                });
    }
}
