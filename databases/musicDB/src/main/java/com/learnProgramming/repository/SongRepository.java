package com.learnProgramming.repository;

import com.learnProgramming.datasource.Datasource;
import com.learnProgramming.filter.Filter;
import com.learnProgramming.filter.SongFilter;
import com.learnProgramming.model.Album;
import com.learnProgramming.model.Song;

import java.util.List;

public class SongRepository extends Repository<Song> {

    public SongRepository(Datasource<Song> dataSource) {
        super(dataSource);
    }

    public List<Song> getAllSongs() {
        return datasource.selectAll();
    }

    public List<Song> getSongsBy(Album album) {
        Filter<Song> songFilter = SongFilter.builder()
                .withAlbumId(album.getId())
                .build();
        return datasource.selectBy(songFilter);
    }
}
