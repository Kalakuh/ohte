package okti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import okti.domain.Flashcard;

public class FlashcardDAO extends GenericDAO<Flashcard> {
    private static final String TABLE_NAME = "Flashcard";
    
    /**
     * Constructor for a flashcard DAO.
     * @param database Database object used for all database related things
     */
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
             + " deck_id integer,\n"
             + " question varchar(150),\n"
             + " answer varchar(150),\n"
             + " FOREIGN KEY (deck_id) REFERENCES Deck(id))";
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
    
    /**
     * Returns all flashcards whose deck id is the given parameter.
     * @param deckId Id of the deck
     * @return All matching flashcards
     */
    public List<Flashcard> findByDeckId(int deckId) {
        try {
            Connection conn = getDatabase().getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE deck_id = ?");
            stmt.setInt(1, deckId);

            ResultSet rs = stmt.executeQuery();
            List<Flashcard> results = new ArrayList<>();

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
