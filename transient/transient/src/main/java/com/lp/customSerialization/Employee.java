package com.lp.customSerialization;

import java.io.*;

public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 691509337054047340L;
    private final Person person;
    private transient Address address;

    public Employee(Person person, Address address) {
        this.person = person;
        this.address = address;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(address.houseNumber());
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        Integer houseNumber = (Integer) ois.readObject();
        this.address = new Address(houseNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "person=" + person +
                ", address=" + address +
                '}';
    }
}
