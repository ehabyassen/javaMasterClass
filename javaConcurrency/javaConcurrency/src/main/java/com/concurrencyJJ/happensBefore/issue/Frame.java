package com.concurrencyJJ.happensBefore.issue;

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
