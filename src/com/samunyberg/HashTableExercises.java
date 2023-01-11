package com.samunyberg;

import java.util.HashMap;
import java.util.HashSet;

public class HashTableExercises {
    public static int mostFrequent(int[] numbers) {
        var map = new HashMap<Integer, Integer>();

        for (var number : numbers) {
            int count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        return result;
    }

    public static int countPairsWithDiff(int[] numbers, int difference) {
        var set = new HashSet<Integer>();
        for (var number : numbers)
            set.add(number);

        var count = 0;
        for (var number : numbers) {
            if (set.contains(number + difference))
                count++;
            if (set.contains(number - difference))
                count++;
            set.remove(number);
        }

        return count;
    }
}
