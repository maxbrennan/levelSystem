package com.max.levelsystem.playerdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public final String IP = "localhost";
    public final int PORT = 3306;
    public final String DATABASE = "player_levels";
    public final String USERNAME = "root";
    public final String PASSWORD = "";

    Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                    USERNAME,
                    PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Connection getConnection() {
        return connection;
    }

}
