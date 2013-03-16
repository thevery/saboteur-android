package com.thevery.saboteur.android.model.cards;

public class ActionSpyCard extends ActionAbstractPlayerCard {
    @Override
    public Card makeCopy() {
        return new ActionSpyCard();
    }
}
