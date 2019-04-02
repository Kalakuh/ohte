package okti.db;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseObjectTest {
    private class MockDatabaseObject extends DatabaseObject {
        
    }
    
    private MockDatabaseObject instance;
    
    @Before
    public void setUp() {
        instance = new MockDatabaseObject();
    }
    
    @Test
    public void DefaultIdIsZero() {
        assertTrue(instance.getId() == 0);
    }

    @Test
    public void IdSetterAndGetterWork() {
        instance.setId(5);
        assertTrue(instance.getId() == 5);
    }
}
