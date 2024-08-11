package com.example;

public class StaticBlock {

    public static int value;

    static {
        value = 3;
        System.out.println("Static block called.");
    }

    static {
        System.out.println("2nd static block called.");
    }

    public StaticBlock() {
        System.out.println("Constructor called.");
    }

    public int getValue() {
        System.out.println("getValue called");
        return value;
    }

    public static void main(String[] args) {
        StaticBlock sb = new StaticBlock();
        sb.getValue();
    }


}
