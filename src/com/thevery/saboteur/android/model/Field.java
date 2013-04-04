package com.thevery.saboteur.android.model;

import com.thevery.saboteur.android.model.cards.*;
import com.thevery.saboteur.android.model.util.Array2D;

import java.util.List;

public class Field {
    public static final int MINIMAL_DISTANCE = 7;

    private final Array2D<Card> area = new Array2D<Card>();

    public Field() {
        area.put(0, 0, PathStartCard.START_CARD);
        List<Card> finishCards = PathFinishCard.FINISH_CARDS;
        area.put(MINIMAL_DISTANCE + 1, -1, finishCards.get(0));
        area.put(MINIMAL_DISTANCE + 1, 0, finishCards.get(1));
        area.put(MINIMAL_DISTANCE + 1, 1, finishCards.get(2));
    }

    public boolean checkTurn(FieldTurnCard card, int x, int y) {
        Card currentCard = area.get(x, y);
        if (card instanceof BoomCard) {
            //you cannot boom empty, start or end card
            return currentCard != null && !(currentCard instanceof PathFinishCard) && !(currentCard instanceof PathStartCard);
        } else if (card instanceof PathCard) {
            if (currentCard != null) {
                return false;//you cannot replace existing card
            }

            //todo: for path check 2) have full path neighbours 3) matches neighbours
            return false;
        } else {
            throw new IllegalArgumentException("unknown card: " + card);
        }
    }


    public void turn(FieldTurnCard card, int x, int y) {
        if (!checkTurn(card, x, y)) {
            //todo: maybe just return false
            throw new IllegalArgumentException("you cannot make such move!");
        }
        if (card instanceof PathCard) {
            area.put(x, y, card);
        } else if (card instanceof BoomCard) {
            area.put(x, y, null);
        } else {
            throw new IllegalStateException("card must be either path or boom");
        }
    }
}