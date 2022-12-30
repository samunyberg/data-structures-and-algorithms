package com.samunyberg;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        var reversed = new StringBuffer();
        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}
