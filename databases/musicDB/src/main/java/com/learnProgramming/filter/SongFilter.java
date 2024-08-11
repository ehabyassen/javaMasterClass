package com.learnProgramming.filter;

import com.learnProgramming.model.Song;

public class SongFilter extends Filter<Song> {

    private int track = Integer.MIN_VALUE;
    private String title;
    private int albumId = Integer.MIN_VALUE;

    private SongFilter() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final SongFilter filter = new SongFilter();

        public Builder withTrack(int track) {
            filter.track = track;
            return this;
        }

        public Builder withTitle(String title) {
            filter.title = title;
            return this;
        }

        public Builder withAlbumId(int albumId) {
            filter.albumId = albumId;
            return this;
        }

        public SongFilter build() {
            return filter;
        }
    }

    @Override
    public String toString() {
        StringBuilder filter = new StringBuilder();
        if (id > Integer.MIN_VALUE) {
            filter.append("id = ").append(id);
        }
        if (track > Integer.MIN_VALUE) {
            if (!filter.isEmpty()) {
                filter.append(" AND ");
            }
            filter.append("track = ").append(track);
        }
        if (title != null) {
            if (!filter.isEmpty()) {
                filter.append(" AND ");
            }
            filter.append("title = ").append("'").append(title).append("'");
        }
        if (albumId > Integer.MIN_VALUE) {
            if (!filter.isEmpty()) {
                filter.append(" AND ");
            }
            filter.append("album = ").append(albumId);
        }
        if (!filter.isEmpty()) {
            filter.insert(0, " WHERE ");
        }
        return filter.toString();
    }
}
