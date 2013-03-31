package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.cards.Card;

public class SkipTurn extends Turn {
    private Card card;

    public SkipTurn(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "card '" + card + "' skipped";
    }
}
