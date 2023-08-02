package com.samunyberg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    public static String reverse(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (var i = words.length - 1; i >= 0; i--)
            reversed.append(words[i]).append(" ");

        return reversed.toString().trim();
    }
}
