package com.lp.abstractClasses;

public class Fish extends Animal {
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("slow")) System.out.println(getExplicitType() + " lazily swimming!");
        else System.out.println(type + " darting frantically!");
    }

    @Override
    public void makeNoise() {
        if (type.equals("Goldfish")) System.out.println(type + " swish!");
        else System.out.println(type + " splash!");
    }
}
