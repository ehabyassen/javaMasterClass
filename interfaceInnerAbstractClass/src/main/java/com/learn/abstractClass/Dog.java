package com.learn.abstractClass;

public class Dog extends Animal {


    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating meat");
    }

    @Override
    public void breath() {
        System.out.println("breath in, breath out loudly");
    }
}
