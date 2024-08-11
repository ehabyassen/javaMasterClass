package com.learnprogramming.playlist;

import java.util.LinkedList;

public class Album {

    private String title;
    private LinkedList<Song> songs;

    public Album(String title) {
        this.title = title;
        this.songs = new LinkedList<>();
    }

    public void addSong(String title, int durationInSeconds) {
        Song song = new Song(title, durationInSeconds);
        songs.add(song);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void setSongs(LinkedList<Song> songs) {
        this.songs = songs;
    }
}
