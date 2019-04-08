package okti.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import okti.domain.Deck;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckDAOTest {
    private Database database;
    private DeckDAO instance;
    
    @Before
    public void setUp() {
        database = new Database("jdbc:sqlite:test.db");
        instance = new DeckDAO(database);
    }
    
    @After
    public void tearDown() throws IOException {
        Files.delete(Paths.get("test.db"));
    }
    
    @Test
    public void gettingLastDeckWorks() {
        try {
            instance.saveOrUpdate(new Deck("Hello"));
            instance.saveOrUpdate(new Deck("World!"));
            instance.saveOrUpdate(new Deck("Hei"));
            assertTrue(instance.findLast().getName().equals("Hei"));
        } catch (SQLException e) {
            fail();
        }
    }
    
    @Test
    public void gettingDeckByKeyWorks() {
        try {
            instance.saveOrUpdate(new Deck("Hello"));
            instance.saveOrUpdate(new Deck("World!"));
            int id = instance.findLast().getId();
            instance.saveOrUpdate(new Deck("Hei"));
            instance.saveOrUpdate(new Deck("Mualima!"));
            assertTrue(instance.findOne(id).getName().equals("World!"));
        } catch (SQLException e) {
            fail();
        }
    }
    
    @Test
    public void gettingAllDecksWorks() {
        try {
            instance.saveOrUpdate(new Deck("Hello"));
            instance.saveOrUpdate(new Deck("World!"));
            List<Deck> decks = instance.findAll();
            assertTrue((decks.get(0).getName().equals("Hello") || decks.get(1).getName().equals("Hello"))
                    && (decks.get(0).getName().equals("World!") || decks.get(1).getName().equals("World!")));
        } catch (SQLException e) {
            fail();
        }
    }
    
    @Test
    public void updatingDeckWorks() {
        try {
            Deck deck = new Deck("Hello");
            instance.saveOrUpdate(deck);
            int id = instance.findLast().getId();
            deck.setId(id);
            
            deck.setName("World!");
            instance.saveOrUpdate(deck);
            assertTrue(instance.findAll().size() == 1 && instance.findOne(id).getName().equals("World!"));
        } catch (SQLException e) {
            fail();
        }
    }
    
    @Test
    public void deletingDeckWorks() {
        try {
            Deck deck = new Deck("Hello");
            instance.saveOrUpdate(deck);
            int id = instance.findLast().getId();
            Deck deck2 = new Deck("Hello");
            instance.saveOrUpdate(deck2);
            int id2 = instance.findLast().getId();
            instance.delete(id2);
            assertTrue(instance.findLast().getId() == id);
        } catch (SQLException e) {
            fail();
        }
    }
}
