package com.learnProgramming.filter;

import com.learnProgramming.model.Entity;

public class Filter<T extends Entity> {

    protected int id = Integer.MIN_VALUE;

    public Filter<T> withId(int id) {
        this.id = id;
        return this;
    }
}
