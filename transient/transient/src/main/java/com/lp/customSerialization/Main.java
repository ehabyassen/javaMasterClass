package com.lp.customSerialization;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Person ehab = new Person("Ehab", 33);
        Address address = new Address(6);
        Employee e1 = new Employee(ehab, address);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.tmp"));
            oos.writeObject(e1);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.tmp"));
            Employee e2 = (Employee) ois.readObject();

            System.out.println(e1);
            System.out.println(e2);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
