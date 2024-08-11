package com.learn.abstractClass;

public class Fish extends Animal {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating see grass");
    }

    @Override
    public void breath() {
        System.out.println("breath in, breath out");
    }
}
