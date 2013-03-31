package com.thevery.saboteur.android.model;

import com.thevery.saboteur.android.model.cards.*;
import com.thevery.saboteur.android.model.util.Array2D;

import java.util.List;

public class Field {
    public static final int MINIMAL_DISTANCE = 7;

    private final Array2D<Cell> area = new Array2D<Cell>();

    public Field() {
        area.put(0, 0, new Cell(PathStartCard.START_CARD));
        List<Card> finishCards = PathFinishCard.FINISH_CARDS;
        area.put(MINIMAL_DISTANCE + 1, -1, new Cell(finishCards.get(0)));
        area.put(MINIMAL_DISTANCE + 1, 0, new Cell(finishCards.get(1)));
        area.put(MINIMAL_DISTANCE + 1, 1, new Cell(finishCards.get(2)));
    }

    public boolean checkTurn(FieldTurnCard card, int x, int y) {
        Cell cell = area.get(x, y, new Cell());
        Card currentCard = cell.getCurrentCard();
        if (card instanceof BoomCard) {
            //you cannot boom empty, start or end card
            return currentCard != null && !(currentCard instanceof PathFinishCard) && !(currentCard instanceof PathStartCard);
        } else if (card instanceof PathCard) {
            //todo: for path check 1) is empty 2) have full path neighbours 3) matches neighbours
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
        Cell cell = area.get(x, y, new Cell(card));
        if (card instanceof PathCard) {
            cell.setCurrentCard(card);
        } else if (card instanceof BoomCard) {
            //todo: maybe remove, not null?
            //todo: maybe make cell = null;
            cell.setCurrentCard(null);
        } else {
            throw new IllegalStateException("card must be either path or boom");
        }
    }


    private static class Cell {
        private Card currentCard;

        private Cell() {
        }

        public Cell(Card startCard) {
            setCurrentCard(startCard);
        }

        public void removeCurrentCard() {
            setCurrentCard(null);
        }

        public Card getCurrentCard() {
            return currentCard;
        }

        public void setCurrentCard(Card currentCard) {
            this.currentCard = currentCard;
        }
    }
}