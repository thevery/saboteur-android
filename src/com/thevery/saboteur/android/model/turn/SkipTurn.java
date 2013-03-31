package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.cards.Card;

public class SkipTurn extends Turn<Card> {
    public SkipTurn(Card card) {
        super(card);
    }

    @Override
    public String toString() {
        return "card '" + getCard() + "' skipped";
    }
}
