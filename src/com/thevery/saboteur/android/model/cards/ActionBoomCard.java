package com.thevery.saboteur.android.model.cards;

public class ActionBoomCard extends ActionAbstractCard {
    @Override
    public Card makeCopy() {
        return new ActionBoomCard();
    }
}
