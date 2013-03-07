package com.thevery.saboteur.android.model;

public class ActionBrakeCard extends ActionAbstractCard {
    public static final int TOTAL_COUNT = 4;

    private final Player.Tool brokenTool;

    public ActionBrakeCard(Player.Tool brokenTool) {
        this.brokenTool = brokenTool;
    }

    public Player.Tool getBrokenTool() {
        return brokenTool;
    }
}
