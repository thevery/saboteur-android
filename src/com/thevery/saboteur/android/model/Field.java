package com.thevery.saboteur.android.model;

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

    public boolean checkTurn(Card card, int x, int y) {
        //todo: add all needed checks and return true/false

        return false;
    }


    //todo: special case for spy card
    public void turn(Card card, int x, int y) {
        Cell cell = area.get(x, y, new Cell(card));
        cell.setCurrentCard(card);
    }


    private static class Cell {
        private Card currentCard;

        public Cell(Card startCard) {
            currentCard = startCard;
        }

        public void removeCurrentCard() {
            currentCard = null;
        }

        public Card getCurrentCard() {
            return currentCard;
        }

        public void setCurrentCard(Card currentCard) {
            this.currentCard = currentCard;
        }
    }
}