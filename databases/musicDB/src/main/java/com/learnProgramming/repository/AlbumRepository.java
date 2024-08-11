package com.learnProgramming.repository;

import com.learnProgramming.datasource.Datasource;
import com.learnProgramming.filter.AlbumFilter;
import com.learnProgramming.filter.Filter;
import com.learnProgramming.model.Album;
import com.learnProgramming.model.Artist;

import java.util.List;

public class AlbumRepository extends Repository<Album> {

    public AlbumRepository(Datasource<Album> datasource) {
        super(datasource);
    }

    public List<Album> getAllAlbums() {
        return datasource.selectAll();
    }

    public List<Album> getAlbumsBy(Artist artist) {
        Filter<Album> albumFilter = AlbumFilter.builder()
                .withArtistId(artist.getId())
                .build();
        return datasource.selectBy(albumFilter);
    }
}
