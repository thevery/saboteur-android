package com.thevery.saboteur.android.model.cards;

public class BoomCard implements FieldTurnCard {
    @Override
    public Card makeCopy() {
        return new BoomCard();
    }
}
