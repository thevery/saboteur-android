package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.cards.Card;

public class Turn<T extends Card> {
    private T card;

    public Turn(T card) {
        this.card = card;
    }

    public T getCard() {
        return card;
    }
}
