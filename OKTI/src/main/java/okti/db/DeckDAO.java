package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import okti.domain.Deck;

public class DeckDAO extends GenericDAO<Deck> {
    private static final String TABLE_NAME = "Deck";
    
    /**
     * Constructor for a deck DAO object.
     * @param database Database object that will be used for all database operations
     */
    public DeckDAO(Database database) {
        super(database, TABLE_NAME);
    }

    @Override
    protected Deck buildFromResultSet(ResultSet rs) {
        try {
            Deck deck = new Deck(rs.getString("name"), rs.getInt("user_id"));
            deck.setId(rs.getInt("id"));
            return deck;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    protected PreparedStatement generateInsertionStatement(Deck deck, Connection conn) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TABLE_NAME + " (name, user_id) VALUES (?, ?)");
            stmt.setString(1, deck.getName());
            stmt.setInt(2, deck.getUserId());
            return stmt;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    protected String generateCreateTableParams() {
        return "(id integer PRIMARY KEY,\n"
             + " user_id integer,\n"
             + " name varchar(50),\n"
             + " FOREIGN KEY (user_id) REFERENCES User(id))";
    }
    
    /**
     * Returns all decks whose user id is the given parameter.
     * @param userId Id of the user
     * @return All matching decks
     */
    public List<Deck> findByUserId(int userId) {
        try {
            Connection conn = getDatabase().getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE user_id = ?");
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();
            List<Deck> results = new ArrayList<>();

            while (rs.next()) {
                results.add(buildFromResultSet(rs));
            }

            stmt.close();
            rs.close();

            conn.close();

            return results;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
}
