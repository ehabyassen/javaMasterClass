package com.learnProgramming.model;

public class Song extends Entity {

    private final int track;
    private final String title;
    private final int albumId;

    public Song(int id, int track, String title, int albumId) {
        super(id);
        this.track = track;
        this.title = title;
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + getId() +
                ", track=" + track +
                ", title='" + title + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}
