package me.lyamray.trickortreat.modules.database;

import java.sql.*;

public class Database {

    private final Connection connection;

    /**
     * Establishes a new database connection to the specified SQLite database path and
     * creates the players table if it does not already exist.
     * @param path the path to the SQLite database file
     * @throws SQLException if a database access error occurs or the URL is null
     */
    public Database(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS players (" +
                    "uuid TEXT PRIMARY KEY," +
                    "username TEXT NOT NULL," +
                    "candy INTEGER NOT NULL DEFAULT 0)");

        }
    }

    /**
     * @throws SQLException if a database access error occurs
     */
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    /**
     * @param uuid The UUID of the player to check.
     * @return true if the player exists, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    public boolean playerExists(String uuid) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM players WHERE uuid = ?")) {
            statement.setString(1, uuid);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }
    }

    /**
     * Adds a new player to the database with the given UUID and username.
     *
     * @param uuid the unique identifier of the player
     * @param username the name of the player
     * @throws SQLException if a database access error occurs
     */
    public void addPlayer(String uuid, String username) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO players (uuid, username) VALUES (?, ?)")) {
            statement.setString(1, uuid);
            statement.setString(2, username);
            statement.executeUpdate();
        }
    }

    /**
     * Retrieves and prints the number of candies the player has. If the player does not exist in the database,
     * the player is added to the database with the given UUID and name.
     *
     * @param uuid The unique identifier of the player.
     * @param name The name of the player.
     * @throws SQLException If an SQL error occurs while accessing the database.
     */
    public void getPlayerCandy(String uuid, String name) throws SQLException {
        if (!playerExists(uuid)) {
            addPlayer(uuid, name);
        } else {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM players WHERE uuid = ?")) {
                statement.setString(1, uuid);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int candy = resultSet.getInt("candy");
                    System.out.println(candy);
                }
            }
        }
    }
}