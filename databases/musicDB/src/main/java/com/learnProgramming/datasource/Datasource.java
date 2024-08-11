package com.learnProgramming.datasource;

import com.learnProgramming.dbUtils.ConnectionFactory;
import com.learnProgramming.filter.Filter;
import com.learnProgramming.model.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Datasource<T extends Entity> {

    private final String tableName;

    public Datasource(String tableName) {
        this.tableName = tableName;
    }

    public List<T> selectAll() {
        String query = "SELECT * " +
                       "FROM " + tableName;
        return selectByQuery(query);
    }

    public List<T> selectBy(Filter<T> filter) {
        String query = "SELECT * " +
                       "FROM " + tableName +
                       filter.toString();
        return selectByQuery(query);
    }

    protected List<T> selectByQuery(String query) {
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = Objects.requireNonNull(conn).createStatement();
             ResultSet result = stmt.executeQuery(query)) {
            return mapResultSet(result);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    protected abstract List<T> mapResultSet(ResultSet result) throws SQLException;
}
