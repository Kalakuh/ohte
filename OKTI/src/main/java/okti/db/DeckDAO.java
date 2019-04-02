package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import okti.domain.Deck;

public class DeckDAO extends GenericDAO<Deck> {
    private static final String TABLE_NAME = "Deck";
    
    public DeckDAO(Database database) {
        super(database, TABLE_NAME);
    }

    @Override
    protected Deck buildFromResultSet(ResultSet rs) {
        try {
            Deck deck = new Deck(rs.getString("name"));
            deck.setId(rs.getInt("id"));
            return deck;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    protected PreparedStatement generateInsertionStatement(Deck deck, Connection conn) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TABLE_NAME + " (name) VALUES (?)");
            stmt.setString(1, deck.getName());
            return stmt;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    protected String generateCreateTableParams() {
        return "(id integer PRIMARY KEY,\n"
             + " name varchar(50))";
    }
}
