package com.samunyberg;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable(int size) {
        entries = new LinkedList[size];
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null)
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;

        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        return entries[index];
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
