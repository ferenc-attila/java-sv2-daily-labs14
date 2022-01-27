package day04;

import java.util.*;

public class PairFinder {

    public int findPairs(int[] arr) {
        int[] numbers = Arrays.copyOf(arr, arr.length);
        Arrays.sort(numbers);
        int count = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                count++;
                i++;
            }
        }
        return count;
    }

    public int findPairsWithMap(int[] arr) {
        Map<Integer, Integer> pairs = new TreeMap<>();
        for (int i : arr) {
            if (!pairs.containsKey(i)) {
                pairs.put(i, 1);
            } else {
                pairs.put(i, pairs.get(i) + 1);
            }
        }
        return pairs.values().stream().mapToInt(integer -> integer / 2).sum();
    }
}
