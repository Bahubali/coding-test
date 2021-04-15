package com.flipkart.cache;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class LevelCache extends AbstractCache {

    private Map<String, String> cacheStore;
    private Map<Integer, List<String>> usages;
    private AbstractCache nextLevel;

    LevelCache(int read, int write, AbstractCache next) {
        this.readTime = read;
        this.writeTime = write;
        this.nextLevel = next;
        this.cacheStore = new HashMap<>();
        this.usages = new TreeMap<>();
    }
    @Override
    public void set(String key, String val) {
        if (!this.cacheStore.containsKey(key)) {
            this.cacheStore.put(key, val);
        }
    }

    public boolean keyExists(String key) {
        return this.cacheStore.containsKey(key);
    }

    @Override
    public Response get(String key) {
        return Response.builder().value(this.cacheStore.get(key)).totalTime(this.readTime).build();
    }

    public AbstractCache getNextLevel() {
        return this.nextLevel;
    }
}
