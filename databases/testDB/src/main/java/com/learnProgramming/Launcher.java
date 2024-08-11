package com.learnProgramming;

import java.io.File;
import java.sql.*;

public class Launcher {

    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + new File("src/main/resources", DB_NAME).getAbsolutePath();
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            stmt.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_EMAIL + " TEXT)");

            insertContacts(stmt);

            selectAllContacts(stmt);
            System.out.println("=".repeat(50));

            updateContact(stmt);

            selectAllContacts(stmt);
            System.out.println("=".repeat(50));

            deleteContact(stmt);

            selectAllContacts(stmt);
            System.out.println("=".repeat(50));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertContacts(Statement stmt) throws SQLException {
        insertContact(stmt, "Ehab", "01234567890", "ehab@x.com");
        insertContact(stmt, "Eslam", "01234567891", "eslam@x.com");
        insertContact(stmt, "Aya", "01234567892", "aya@x.com");
    }

    private static void insertContact(Statement stmt, String name, String phone, String email) throws SQLException {
        stmt.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ",  " + COLUMN_EMAIL + ") " +
                "VALUES('" + name + "', '" + phone + "', '" + email + "')");
    }

    private static void selectAllContacts(Statement stmt) throws SQLException {
        String queryString = "SELECT ROWID, " + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + " " +
                              "FROM " + TABLE_CONTACTS;
        try (ResultSet result = stmt.executeQuery(queryString)) {
            System.out.println("id | name | phone | email");
            while (result.next()) {
                int id = result.getInt("ROWID");
                String name = result.getString(COLUMN_NAME);
                String phone = result.getString(COLUMN_PHONE);
                String email = result.getString(COLUMN_EMAIL);
                System.out.println(id + " | " + name + " | " + phone + " | " + email);
            }
        }
    }

    private static void deleteDuplicates(Statement stmt) throws SQLException {
        stmt.execute("DELETE FROM " + TABLE_CONTACTS + " " +
                          "WHERE ROWID NOT IN (" +
                                                "SELECT min(ROWID) " +
                                                "FROM " + TABLE_CONTACTS + " " +
                                                "GROUP BY " + COLUMN_NAME + ")");
    }

    private static void updateContact(Statement stmt) throws SQLException {
        stmt.execute("UPDATE " + TABLE_CONTACTS + " " +
                          "SET " + COLUMN_PHONE + " = '01234567333' " +
                          "WHERE " + COLUMN_NAME + " = 'Aya'");
    }

    private static void deleteContact(Statement stmt) throws SQLException {
        stmt.execute("DELETE FROM " + TABLE_CONTACTS + " " +
                          "WHERE " + COLUMN_NAME + " = 'Aya'");
    }
}
