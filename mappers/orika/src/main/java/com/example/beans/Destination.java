package com.example.beans;

public class Destination {

    private String givenName;
    private int age;

    public Destination(String givenName, int age) {
        this.givenName = givenName;
        this.age = age;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
