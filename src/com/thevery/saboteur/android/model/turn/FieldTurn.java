package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.cards.Card;

/**
 * Some turn that goes on field, i.e. path or boom
 */
public class FieldTurn extends Turn {
    private Card card;//todo: probably more specific
    private int x;
    private int y;

    public FieldTurn(Card card, int x, int y) {
        this.card = card;
        this.x = x;
        this.y = y;
    }

    public Card getCard() {
        return card;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "card '" + card + "' to x=" + x + ", y=" + y;
    }
}
