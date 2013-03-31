package com.thevery.saboteur.android.model.cards;

public class ActionSpyTurnCard implements PlayerTurnCard {
    @Override
    public Card makeCopy() {
        return new ActionSpyTurnCard();
    }
}
