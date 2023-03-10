package com.samunyberg;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void reverse() {
        if (isEmpty()) return;

        var previous = first;
        var current = previous.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        var pointer1 = first;
        var pointer2 = first;

        for (int i = 0; i < k - 1; i++) {
            pointer2 = pointer2.next;
            if (pointer2 == null) {
                throw new IllegalArgumentException();
            }
        }

        while (pointer2 != last) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1.value;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        var pointer1 = first;
        var pointer2 = first;
        while (pointer2 != last && pointer2.next != last) {
            pointer2 = pointer2.next.next;
            pointer1 = pointer1.next;
        }

        if (pointer2 == last)
            System.out.println(pointer1.value);
        else
            System.out.println(pointer1.value + ", " + pointer1.next.value);
    }

    public boolean hasLoop() {
        if (isEmpty())
            throw new IllegalStateException();

        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void print() {
        var current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
