package com.samunyberg;

import java.util.HashMap;

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
}
