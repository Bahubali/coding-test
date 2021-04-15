package com.flipkart.cache;

public abstract class AbstractCache {

    protected int readTime;
    protected int writeTime;

    public abstract void set(String key, String val);
    public abstract Response get(String key);
    public abstract boolean keyExists(String key);
    public abstract AbstractCache getNextLevel();
}
