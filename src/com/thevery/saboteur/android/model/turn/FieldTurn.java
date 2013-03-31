package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.cards.FieldTurnCard;

/**
 * Some turn that goes on field, i.e. path or boom
 */
public class FieldTurn extends Turn<FieldTurnCard> {
    private int x;
    private int y;

    public FieldTurn(FieldTurnCard card, int x, int y) {
        super(card);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "card '" + getCard() + "' to x=" + getX() + ", y=" + getY();
    }
}
