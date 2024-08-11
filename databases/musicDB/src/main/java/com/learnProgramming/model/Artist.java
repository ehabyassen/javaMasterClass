package com.learnProgramming.model;

public class Artist extends Entity {

    private final String name;

    public Artist(int id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
