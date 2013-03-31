package com.thevery.saboteur.android.model.cards;

public class SpyCard implements PlayerTurnCard {
    @Override
    public Card makeCopy() {
        return new SpyCard();
    }
}
