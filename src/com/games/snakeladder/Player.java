package com.games.snakeladder;

/**
 * Created by bahubali.n on 27/05/19.
 */
public class Player {
    private String name;
    private Panel currentPanel;

    public Player(String name, Panel panel) {
        this.name = name;
        this.currentPanel = panel;
    }

    public void setCurrentPanel(Panel panel) {
        this.currentPanel = panel;
    }

    public Panel getCurrentPanel() {
        return this.currentPanel;
    }

    public String getName() {
        return this.name;
    }
}
