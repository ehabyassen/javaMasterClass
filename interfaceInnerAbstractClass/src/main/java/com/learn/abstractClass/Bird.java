package com.learn.abstractClass;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breath() {
        System.out.println("breath in, breath out softly");
    }
}
