package com.learnProgramming.model;

public class Entity {

    private final int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }
}
