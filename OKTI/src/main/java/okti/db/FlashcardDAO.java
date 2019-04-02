package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import okti.domain.Flashcard;

public class FlashcardDAO extends GenericDAO<Flashcard> {
    private static final String TABLE_NAME = "Flashcard";
    
    public FlashcardDAO(Database database) {
        super(database, TABLE_NAME);
    }

    @Override
    protected Flashcard buildFromResultSet(ResultSet rs) {
        try {
            Flashcard flashcard = new Flashcard(rs.getInt("deck_id"), rs.getString("question"), rs.getString("answer"));
            flashcard.setId(rs.getInt("id"));
            return flashcard;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    protected String generateCreateTableParams() {
        return "(id integer PRIMARY KEY,\n"
             + " decd_id integer,\n"
             + " question varchar(150),\n"
             + " answer varchar(150),\n"
             + " FOREIGN KEY (asiakas_id) REFERENCES Asiakas(id))";
    }

    @Override
    protected PreparedStatement generateInsertionStatement(Flashcard flashcard, Connection conn) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TABLE_NAME + " (deck_id, question, answer) VALUES (?, ?, ?)");
            stmt.setInt(1, flashcard.getDeckId());
            stmt.setString(2, flashcard.getQuestion());
            stmt.setString(3, flashcard.getAnswer());
            return stmt;
        } catch (SQLException e) {
            return null;
        }
    }
}
