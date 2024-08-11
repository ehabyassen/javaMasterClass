package com.learnProgramming.datasource;

import com.learnProgramming.model.Song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDataSource extends Datasource<Song> {

    private static final String TABLE_SONGS = "songs";
    private static final String COLUMN_SONG_ID = "_id";
    private static final String COLUMN_SONG_TRACK = "track";
    private static final String COLUMN_SONG_TITLE = "title";
    private static final String COLUMN_SONG_ALBUM = "album";

    public SongDataSource() {
        super(TABLE_SONGS);
    }

    @Override
    protected List<Song> mapResultSet(ResultSet result) throws SQLException {
        List<Song> songs = new ArrayList<>();
        while (result.next()) {
            songs.add(new Song(result.getInt(COLUMN_SONG_ID),
                    result.getInt(COLUMN_SONG_TRACK),
                    result.getString(COLUMN_SONG_TITLE),
                    result.getInt(COLUMN_SONG_ALBUM)));
        }
        return songs;
    }
}
