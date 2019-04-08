package okti.domain;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FlashcardTest {
    private Flashcard instance;
    
    @Before
    public void setUp() {
        instance = new Flashcard(1, "tira", "parasta");
    }
    
    @Test
    public void CardDeckIdGetterWorks() {
        assertTrue(instance.getDeckId() == 1);
    }
    
    @Test
    public void CardQuestionGetterWorks() {
        assertTrue(instance.getQuestion().equals("tira"));
    }
    
    @Test
    public void CardAnswerGetterWorks() {
        assertTrue(instance.getAnswer().equals("parasta"));
    }
}
