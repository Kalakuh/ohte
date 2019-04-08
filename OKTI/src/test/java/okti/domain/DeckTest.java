package okti.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    private Deck instance;
    
    @Before
    public void setUp() {
        instance = new Deck("tira");
    }
    
    @Test
    public void DeckNameGetterWorks() {
        assertTrue(instance.getName().equals("tira"));
    }
    
    @Test
    public void DeckNameSetterWorks() {
        instance.setName("tito");
        assertTrue(instance.getName().equals("tito"));
    }
}
