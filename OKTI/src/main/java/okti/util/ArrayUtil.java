package okti.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
    /**
     * Private constructor so that jacoco reporting works correctly.
     */
    private ArrayUtil() {
        
    }
    
    /**
     * Takes a random subset of specified size of elements from ArrayList given in parameters
     * @param <T> Type of ArrayList's elements
     * @param arr ArrayList from where the elements are chosen
     * @param n Number of random elements to choose
     * @return Random subset of specified size
     */
    public static <T> List<T> selectRandomSubsetOfSizeN(List<T> arr, int n) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            indices.add(i);
        }
        List<T> rnd = new ArrayList<>();
        while (n > 0 && indices.size() > 0) {
            int index = (int)(Math.random() * indices.size());
            rnd.add(arr.get(indices.get(index)));
            indices.remove(index);
            n--;
        }
        return rnd;
    }
}
