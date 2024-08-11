package com.learnProgramming.repository;

import com.learnProgramming.datasource.Datasource;
import com.learnProgramming.model.Artist;

import java.util.List;

public class ArtistRepository extends Repository<Artist> {

    public ArtistRepository(Datasource<Artist> datasource) {
        super(datasource);
    }

    public List<Artist> getAllArtists() {
        return datasource.selectAll();
    }
}
