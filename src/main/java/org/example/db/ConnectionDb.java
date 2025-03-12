package org.example.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDb  {

    Properties properties = new Properties();
    String dbPath;

    public Connection Connection() throws SQLException {
        Connection conn;

        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
            dbPath = properties.getProperty("database.path");
        } catch (IOException e) {
            throw new SQLException("Error reading config file: ", e);
        }

        // Check if dbPath is null in the case dbPath is null, it throws a sqlException.

        if (dbPath == null || dbPath.isEmpty()) {
            throw new SQLException("Database path is not set in the properties file.");
        }


        // Connection in sqlite 3

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found: " + e.getMessage());
            throw new SQLException("JDBC driver not found", e);
        } catch (SQLException e) {
            System.err.println("Error connecting to SQLite: " + e.getMessage());
            throw e;
        }
    }
}
