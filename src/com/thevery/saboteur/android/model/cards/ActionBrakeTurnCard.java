package com.thevery.saboteur.android.model.cards;

import com.thevery.saboteur.android.model.Player;

public class ActionBrakeTurnCard implements PlayerTurnCard {
    private final Player.Tool brokenTool;

    public ActionBrakeTurnCard(Player.Tool brokenTool) {
        this.brokenTool = brokenTool;
    }

    public Player.Tool getBrokenTool() {
        return brokenTool;
    }

    @Override
    public Card makeCopy() {
        return new ActionBrakeTurnCard(brokenTool);
    }
}
