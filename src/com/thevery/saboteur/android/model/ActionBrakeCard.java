package com.thevery.saboteur.android.model;

public class ActionBrakeCard extends ActionAbstractCard {
    private final Player.Tool brokenTool;

    public ActionBrakeCard(Player.Tool brokenTool) {
        this.brokenTool = brokenTool;
    }

    public Player.Tool getBrokenTool() {
        return brokenTool;
    }
}
