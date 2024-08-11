package com.lp.abstractClasses;

public class Dog extends Mammal {

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("slow")) System.out.println(getExplicitType() + " Walking!");
        else System.out.println(type + " Running!");
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds hair all the time");
    }

    @Override
    public void makeNoise() {
        if (type.equals("Wolf")) System.out.println(type + " Howling!");
        else System.out.println(type + " Woof!");
    }
}
