package com.thevery.saboteur.android.model.cards;

public class ActionBoomCard implements FieldTurnCard {
    @Override
    public Card makeCopy() {
        return new ActionBoomCard();
    }
}
