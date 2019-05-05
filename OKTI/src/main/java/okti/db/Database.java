package okti.db;

import java.sql.*;

/**
 * Class that implements the functionality for accessing the database.
 */
public class Database {
    private final String databaseAddress;

    /**
     * Constructor for the database.
     * @param databaseAddress Address of the database.
     */
    public Database(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }

    /**
     * Creates a new connection and returns it.
     * @return A new connection
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
}