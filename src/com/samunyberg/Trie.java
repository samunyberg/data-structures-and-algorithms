package com.samunyberg;

import java.util.HashMap;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value=" + value;

        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (current.children.get(ch) == null)
                current.children.put(ch, new Node(ch));
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }
}
