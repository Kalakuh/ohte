package okti.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    
    @Before
    public void setUp() {
        database = new Database("jdbc:sqlite:test.db");
    }
    
    @After
    public void tearDown() throws IOException {
        Files.delete(Paths.get("test.db"));
    }

    @Test
    public void GetConnectionReturnsConnection() {
        try {
            Connection conn = database.getConnection();
            assertTrue(conn != null);
        } catch (SQLException e) {
            fail();
        }
    }
}
