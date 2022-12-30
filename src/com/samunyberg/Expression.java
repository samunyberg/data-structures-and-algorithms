package com.samunyberg;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private String expression;
    private List<Character> openingBrackets = Arrays.asList('(', '<', '[', '{');
    private List<Character> closingBrackets = Arrays.asList(')', '>', ']', '}');

    public Expression(String expression) {
        this.expression = expression;
    }

    public boolean isBalanced() {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (isOpeningBracket(ch))
                stack.push(ch);

            if (isClosingBracket(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(ch, top)) return false;
            }
        }

        return stack.empty();
    }

    private boolean bracketsMatch(char opening, char closing) {
        return openingBrackets.indexOf(opening) == closingBrackets.indexOf(closing);
    }

    private boolean isOpeningBracket(char ch) {
        return openingBrackets.contains(ch);
    }

    private boolean isClosingBracket(char ch) {
        return closingBrackets.contains(ch);
    }
}
