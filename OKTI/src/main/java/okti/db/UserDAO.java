package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import okti.domain.User;

public class UserDAO extends GenericDAO<User> {
    private static final String TABLE_NAME = "User";
    
    /**
     * Constructor for a user DAO.
     * @param database Database object used for all database related things
     */
    public UserDAO(Database database) {
        super(database, TABLE_NAME);
    }

    @Override
    protected User buildFromResultSet(ResultSet rs) {
        try {
            User user = new User(rs.getString("username"), rs.getString("password"));
            user.setId(rs.getInt("id"));
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    protected String generateCreateTableParams() {
        return "(id integer PRIMARY KEY,\n"
             + " username varchar(30),\n"
             + " password varchar(32))";
    }

    @Override
    protected PreparedStatement generateInsertionStatement(User user, Connection conn) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TABLE_NAME + " (username, password) VALUES (?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            return stmt;
        } catch (SQLException e) {
            return null;
        }
    }
}
