package com.example;

public class StaticApp {

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest("1st instance");
        System.out.println(st1.getName() + " is instance no. " + st1.getNumOfInstances());

        StaticTest st2 = new StaticTest("2nd instance");
        System.out.println(st2.getName() + " is instance no. " + st2.getNumOfInstances());

        System.out.println(st1.getName() + " is instance no. " + st1.getNumOfInstances());
    }
}
