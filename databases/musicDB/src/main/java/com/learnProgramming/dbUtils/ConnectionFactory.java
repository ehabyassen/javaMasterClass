package com.learnProgramming.dbUtils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DB_NAME = "music.db";
    private static final String DB_FILE_PATH = new File("src/main/resources", DB_NAME).getAbsolutePath();
    private static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_FILE_PATH;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return null;
        }
    }
}
