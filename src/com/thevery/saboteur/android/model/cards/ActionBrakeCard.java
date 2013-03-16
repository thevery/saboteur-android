package com.thevery.saboteur.android.model.cards;

import com.thevery.saboteur.android.model.Player;

public class ActionBrakeCard extends ActionAbstractPlayerCard {
    private final Player.Tool brokenTool;

    public ActionBrakeCard(Player.Tool brokenTool) {
        this.brokenTool = brokenTool;
    }

    public Player.Tool getBrokenTool() {
        return brokenTool;
    }

    @Override
    public Card makeCopy() {
        return new ActionBrakeCard(brokenTool);
    }
}
