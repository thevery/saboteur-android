package com.thevery.saboteur.android.model.cards;

public class ActionSpyCard extends ActionAbstractCard {
    @Override
    public Card makeCopy() {
        return new ActionSpyCard();
    }
}
