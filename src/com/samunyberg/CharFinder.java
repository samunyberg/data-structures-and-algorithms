package com.samunyberg;

import java.util.HashMap;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
        var map = new HashMap<Character, Integer>();
        var array = str.toCharArray();

        for (var ch : array) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        for (var ch : array) {
            if (map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
