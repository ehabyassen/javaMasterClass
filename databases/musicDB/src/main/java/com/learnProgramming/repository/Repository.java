package com.learnProgramming.repository;

import com.learnProgramming.datasource.Datasource;
import com.learnProgramming.model.Entity;

public abstract class Repository<T extends Entity> {

    protected final Datasource<T> datasource;

    public Repository(Datasource<T> datasource) {
        this.datasource = datasource;
    }
}
