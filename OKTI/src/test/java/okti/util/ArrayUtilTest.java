package okti.util;

import java.util.ArrayList;
import java.util.List;
import okti.util.ArrayUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtilTest {    
    
    @Test
    public void RandomSubsetOfEmptyListReturnsEmptyList() {
        List<Integer> list = new ArrayList<>();
        assertTrue(ArrayUtil.selectRandomSubsetOfSizeN(list, 100).isEmpty());
    }
    
    @Test
    public void RandomSubsetOfNonEmptyListReturnsNonEmptyList() {
        List<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(1337);
        assertTrue(!ArrayUtil.selectRandomSubsetOfSizeN(list, 100).isEmpty());
    }
    
    @Test
    public void RandomSubsetOfListContainingIdenticalElementsReturnsMultipleElements() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        List<Integer> result = ArrayUtil.selectRandomSubsetOfSizeN(list, 3);
        assertTrue(result.get(0) == 0 && result.get(1) == 0 && result.get(2) == 0);
    }
    
    @Test
    public void RandomSubsetOfListReturnsCorrectNumberOfElementes() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertTrue(ArrayUtil.selectRandomSubsetOfSizeN(list, 2).size() == 2);
    }
}
