package com.flipkart.cache.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.List;

public class LRUCache {

    private HashMap<Character, Integer> cache;
    private HashMap<Character, Integer> cacheAccessMap;
    private TreeMap<Integer, List<Character>> frequencies;

    private int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.cacheAccessMap = new HashMap<>();
        this.frequencies = new TreeMap<>();
    }

    public Integer get(Character key) {
        if (!cache.containsKey(key)) return -1;

        int frequency = this.cacheAccessMap.get(key);
        this.frequencies.get(frequency).remove(new Character(key));
        if (this.frequencies.get(frequency).isEmpty()) {
            this.frequencies.remove(frequency);
        }
        this.frequencies.computeIfAbsent(frequency+1, k -> new LinkedList<Character>())
                .add(key);
        this.cacheAccessMap.put(key, frequency+1);
        return this.cache.get(key);
    }

    public void set(Character key, Integer val) {
        if (!cache.containsKey(key)) {
            if (cache.size() == this.capacity) {
                int leastFrequency = this.frequencies.firstKey();
                Character keyToDelete = this.frequencies.get(leastFrequency).remove(0);
                if (this.frequencies.get(leastFrequency).isEmpty())
                    this.frequencies.remove(leastFrequency);

                this.cache.remove(keyToDelete);
                this.cacheAccessMap.remove(keyToDelete);
            }
            this.cache.put(key, val);
            this.cacheAccessMap.put(key, 1);

            this.frequencies.computeIfAbsent(1, k -> new LinkedList<Character>())
                    .add(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set('A', 10);
        cache.set('B', 20);
        cache.set('C', 30);
        cache.set('D', 40);
        cache.set('E', 50);
        System.out.println(cache.get('A'));
        System.out.println(cache.get('A'));
        System.out.println(cache.get('A'));
        System.out.println(cache.get('C'));
        System.out.println(cache.get('D'));
        System.out.println(cache.get('B'));
        cache.set('F', 60);
        System.out.println(cache.get('E'));
    }
}
