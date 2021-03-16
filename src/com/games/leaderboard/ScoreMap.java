package com.games.leaderboard;

import java.util.Comparator;

public class ScoreMap<K, V> {
    
    private ScoreNode<K, V> rootNode;
    private Comparator<? super K> comparator;


    public ScoreMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
        this.rootNode = null;
    }
    
    public void upsertScore(Integer score, Integer val) {
        
    }
    
    private ScoreNode getEntry(Object key) {
        Comparator<? super K> cpr = comparator;
        ScoreNode<K, V> p = this.rootNode;
        while (p != null) {
            
        }
    }
}
