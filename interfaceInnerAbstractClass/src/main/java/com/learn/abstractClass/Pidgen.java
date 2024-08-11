package com.learn.abstractClass;

public class Pidgen extends Bird implements canFly {
    public Pidgen(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("hovering above the fields");
    }
}
