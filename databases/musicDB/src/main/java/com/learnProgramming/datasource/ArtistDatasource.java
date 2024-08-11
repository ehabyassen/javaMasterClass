package com.learnProgramming.datasource;

import com.learnProgramming.model.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDatasource extends Datasource<Artist> {

    private static final String TABLE_ARTISTS = "artists";
    private static final String COLUMN_ARTIST_ID = "_id";
    private static final String COLUMN_ARTIST_NAME = "name";

    public ArtistDatasource() {
        super(TABLE_ARTISTS);
    }

    @Override
    protected List<Artist> mapResultSet(ResultSet result) throws SQLException {
        List<Artist> artists = new ArrayList<>();
        while (result.next()) {
            artists.add(new Artist(result.getInt(COLUMN_ARTIST_ID),
                    result.getString(COLUMN_ARTIST_NAME)));
        }
        return artists;
    }
}
