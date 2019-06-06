package com.games.snakeladder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Panel {
    private int number;
    Map<String, Player> players;

    public Panel(int panelNumber) {
        this.number = panelNumber;
        this.players = new HashMap<>();
    }

    public int getNumber() {
        return this.number;
    }

    public void addPlayer(Player player) {
        if (!players.containsKey(player.getName())) {
            players.put(player.getName(), player);
        }
    }
}
