package com.learnProgramming;

import com.learnProgramming.datasource.AlbumDatasource;
import com.learnProgramming.datasource.ArtistDatasource;
import com.learnProgramming.datasource.SongDataSource;
import com.learnProgramming.model.Album;
import com.learnProgramming.model.Artist;
import com.learnProgramming.model.Song;
import com.learnProgramming.repository.AlbumRepository;
import com.learnProgramming.repository.ArtistRepository;
import com.learnProgramming.repository.SongRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        printAllArtists();
//        System.out.println("=".repeat(50));
//        printAllSongs();
//        System.out.println("=".repeat(50));
//        printAllAlbums();
//        System.out.println("=".repeat(50));
//        printArtistAndHisAlbums();
//        System.out.println("=".repeat(50));
        printAlbumAndSongs();
    }

    private static void printAlbumAndSongs() {
        AlbumRepository albumRepository = new AlbumRepository(new AlbumDatasource());
        Album album = albumRepository.getAllAlbums().get(0);
        System.out.println(album);
        SongRepository songRepository = new SongRepository(new SongDataSource());
        List<Song> albumSongs = songRepository.getSongsBy(album);
        albumSongs.forEach(System.out::println);
    }

    private static void printArtistAndHisAlbums() {
        ArtistRepository artistRepository = new ArtistRepository(new ArtistDatasource());
        Artist artist = artistRepository.getAllArtists().get(0);
        System.out.println(artist);
        AlbumRepository albumRepository = new AlbumRepository(new AlbumDatasource());
        List<Album> albumsByArtist = albumRepository.getAlbumsBy(artist);
        albumsByArtist.forEach(System.out::println);
    }

    private static void printAllAlbums() {
        AlbumRepository albumRepository = new AlbumRepository(new AlbumDatasource());
        List<Album> allAlbums = albumRepository.getAllAlbums();
        allAlbums.forEach(System.out::println);
    }

    private static void printAllSongs() {
        SongRepository songRepository = new SongRepository(new SongDataSource());
        List<Song> allSongs = songRepository.getAllSongs();
        allSongs.forEach(System.out::println);
    }

    private static void printAllArtists() {
        ArtistRepository artistRepository = new ArtistRepository(new ArtistDatasource());
        List<Artist> allArtists = artistRepository.getAllArtists();
        allArtists.forEach(System.out::println);
    }
}
