package com.example;

public class StaticTest {

    private String name;
    private static int numOfInstances = 0;

    public StaticTest(String name) {
        this.name = name;
        numOfInstances++;
    }

    public String getName() {
        return name;
    }

    public int getNumOfInstances() {
        return numOfInstances;
    }
}
