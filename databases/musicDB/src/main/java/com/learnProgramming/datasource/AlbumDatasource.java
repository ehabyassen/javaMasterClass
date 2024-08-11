package com.learnProgramming.datasource;

import com.learnProgramming.model.Album;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDatasource extends Datasource<Album> {

    private static final String TABLE_ALBUMS = "albums";
    private static final String COLUMN_ALBUM_ID = "_id";
    private static final String COLUMN_ALBUM_NAME = "name";
    private static final String COLUMN_ALBUM_ARTIST = "artist";

    public AlbumDatasource() {
        super(TABLE_ALBUMS);
    }

    @Override
    protected List<Album> mapResultSet(ResultSet result) throws SQLException {
        List<Album> albums = new ArrayList<>();
        while (result.next()) {
            albums.add(new Album(result.getInt(COLUMN_ALBUM_ID),
                    result.getString(COLUMN_ALBUM_NAME),
                    result.getInt(COLUMN_ALBUM_ARTIST)));
        }
        return albums;
    }
}
