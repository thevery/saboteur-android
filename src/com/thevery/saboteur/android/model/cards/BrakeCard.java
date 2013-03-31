package com.thevery.saboteur.android.model.cards;

import com.thevery.saboteur.android.model.Player;

public class BrakeCard implements PlayerTurnCard {
    private final Player.Tool brokenTool;

    public BrakeCard(Player.Tool brokenTool) {
        this.brokenTool = brokenTool;
    }

    public Player.Tool getBrokenTool() {
        return brokenTool;
    }

    @Override
    public Card makeCopy() {
        return new BrakeCard(brokenTool);
    }
}
