package com.thevery.saboteur.android.model;

public class ActionBoomCard extends ActionAbstractCard {
    @Override
    public Card makeCopy() {
        return new ActionBoomCard();
    }
}
