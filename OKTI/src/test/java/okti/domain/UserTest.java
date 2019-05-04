package okti.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    private User instance;
    
    @Before
    public void setUp() {
        instance = new User("nimi", "salasana");
    }
    
    @Test
    public void getUsernameReturnsCorrectName() {
        assertTrue(instance.getUsername().equals("nimi"));
    }
    
    @Test
    public void getPasswordReturnsCorrectPassword() {
        assertTrue(instance.getPassword().equals("salasana"));
    }
    
    @Test
    public void checkPasswordAcceptsValidPassword() {
        assertTrue(instance.checkPassword("salasana"));
    }
    
    @Test
    public void checkPasswordDoesNotAcceptInvalidPassword() {
        assertTrue(!instance.checkPassword("ananas"));
    }
}
