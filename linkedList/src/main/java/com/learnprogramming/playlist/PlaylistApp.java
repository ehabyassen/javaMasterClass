package com.learnprogramming.playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlaylistApp {

    public static void main(String[] args) {
        Album album1 = new Album("album1");
        album1.addSong("Song1", 300);
        album1.addSong("Song2", 400);
        album1.addSong("Song3", 500);

        Album album2 = new Album("album2");
        album2.addSong("Song4", 350);
        album2.addSong("Song5", 450);

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.forEach(album -> playlist.addAll(album.getSongs()));
        ListIterator<Song> it = playlist.listIterator();

        boolean quit = false;
        while(!quit) {
            printCurrentlyPlaying(it);
            printOptions();
            switch (new Scanner(System.in).nextInt()) {
                case 0 -> quit = true;
                case 1 -> skipToNext(it);
                case 2 -> skipToPrev(it);
                case 3 -> replayCurrent(it);
                case 4 -> listSongs(playlist);
            }
        }
    }

    private static void listSongs(LinkedList<Song> playlist) {
        System.out.println(playlist.stream().map(Song::toString).collect(Collectors.joining(", ")));
    }

    private static void replayCurrent(ListIterator<Song> it) {

    }

    private static void skipToPrev(ListIterator<Song> it) {
        if (it.hasPrevious()) {
            it.previous();
        }
    }

    private static void skipToNext(ListIterator<Song> it) {
        if(it.hasNext()) {
            it.next();
        }
    }

    private static void printCurrentlyPlaying(ListIterator<Song> it) {
        System.out.println("Currently playing:" + it.next());
        it.previous();
    }

    private static void printOptions() {
        System.out.println(
                """
                    Options:
                        0: quit
                        1: skip forward to next song
                        2: skip backward to previous song
                        3: replay current song
                        4: list songs in the play list
                    """
        );
    }
}
