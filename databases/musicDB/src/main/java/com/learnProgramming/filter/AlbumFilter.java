package com.learnProgramming.filter;

import com.learnProgramming.model.Album;

public class AlbumFilter extends Filter<Album> {

    private String name;
    private int artistId = Integer.MIN_VALUE;

    private AlbumFilter() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final AlbumFilter filter = new AlbumFilter();

        public Builder withName(String name) {
            filter.name = name;
            return this;
        }

        public Builder withArtistId(int artistId) {
            filter.artistId = artistId;
            return this;
        }

        public AlbumFilter build() {
            return filter;
        }
    }

    @Override
    public String toString() {
        StringBuilder filter = new StringBuilder();
        if (id > Integer.MIN_VALUE) {
            filter.append("id = ").append(id);
        }
        if (name != null) {
            if (!filter.isEmpty()) {
                filter.append(" AND ");
            }
            filter.append("name = ").append("'").append(name).append("'");
        }
        if (artistId > Integer.MIN_VALUE) {
            if (!filter.isEmpty()) {
                filter.append(" AND ");
            }
            filter.append("artist = ").append(artistId);
        }
        if (!filter.isEmpty()) {
            filter.insert(0, " WHERE ");
        }
        return filter.toString();
    }
}
