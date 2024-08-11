package com.learnProgramming.filter;

import com.learnProgramming.model.Artist;

public class ArtistFilter extends Filter<Artist> {

    private String name;

    private ArtistFilter() {}

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ArtistFilter filter = new ArtistFilter();

        public Builder withName(String name) {
            filter.name = name;
            return this;
        }

        public ArtistFilter build() {
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
        if (!filter.isEmpty()) {
            filter.insert(0, " WHERE ");
        }
        return filter.toString();
    }
}
