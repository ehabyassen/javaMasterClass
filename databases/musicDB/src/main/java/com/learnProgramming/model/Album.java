package com.learnProgramming.model;

public class Album extends Entity {

    private final String name;
    private final int artistId;

    public Album(int id, String name, int artistId) {
        super(id);
        this.name = name;
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                '}';
    }
}
