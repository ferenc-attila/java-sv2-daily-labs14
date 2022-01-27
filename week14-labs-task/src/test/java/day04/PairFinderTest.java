package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    PairFinder pairFinder = new PairFinder();

    @Test
    void findPairsTest() {
        int[] testArray = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, pairFinder.findPairs(testArray));
    }

    @Test
    void findPairsWithMapTest() {
        int[] testArray = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};
        assertEquals(4, pairFinder.findPairsWithMap(testArray));
    }
}