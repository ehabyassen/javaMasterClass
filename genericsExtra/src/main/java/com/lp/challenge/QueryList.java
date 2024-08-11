package com.lp.challenge;

import java.util.ArrayList;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T> {

    public QueryList<T> getMatches(String field, String value) {
        QueryList<T> matches = new QueryList<>();
        stream().filter(student -> student.matchFieldValue(field, value))
                .forEach(matches::add);
        return matches;
    }
}
