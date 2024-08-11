package com.learnprogramming.playlist;

public class Song {

    private String title;
    private int durationInSeconds;

    public Song(String title, int durationInSeconds) {
        this.title = title;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                '}';
    }
}
