package com.concurrencyJJ.happensBefore.volatileSolution;

public class Frame {

    private final String name;

    public Frame(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
