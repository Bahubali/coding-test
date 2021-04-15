package com.flipkart.cache;

import javax.swing.*;

public class CacheService {

    private AbstractCache multilevelCache;

    CacheService(AbstractCache levelCache) {
        this.multilevelCache = levelCache;
    }

    public void set(String key, String val) {
        AbstractCache current = this.multilevelCache;
        while (current != null) {
            if (!current.keyExists(key)) {
                current.set(key, val);
                current = current.getNextLevel();
            } else {
                break;
            }
        }
    }

    public String get(String key) {
        AbstractCache cache = this.multilevelCache;
        String value = null;
        int totalReadTime = 0;
        while (cache != null && !cache.keyExists(key)) {
            cache = cache.getNextLevel();
            totalReadTime += cache.readTime;
        }
        if (cache != null) {
            Response response = cache.get(key);
            value = response.getValue();
            totalReadTime += response.getTotalTime();
        }
        return null;
    }

    public static void main(String[] args) {
        AbstractCache level3 = new LevelCache(3, 2, null);
        AbstractCache level2 = new LevelCache(4, 1, level3);
        AbstractCache level1 = new LevelCache(2, 3, level2);
        CacheService cacheService = new CacheService(level1);
        cacheService.set("k1", "v1");
        cacheService.set("k2", "v2");
        System.out.println(cacheService.get("k1"));
    }
}
