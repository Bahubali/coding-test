package com.games.leaderboard;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.Set;

@Data
@Builder
public class ScoreNode<K, V>{

    private K key;
    private Set<V> val;
    private int size;
    private ScoreNode left, right;

    ScoreNode(K key, V val) {
        this.key = key;
        this.val.add(val);
        this.left = null;
        this.right = null;
    }
    
}
