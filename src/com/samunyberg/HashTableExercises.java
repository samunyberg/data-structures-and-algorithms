package com.samunyberg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};

            map.put(numbers[i], i);
        }

        return null;
    }
}
