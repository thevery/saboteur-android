package com.thevery.saboteur.android.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Field {
    public static final int MINIMAL_DISTANCE = 7;

    private final Map<Integer, Map<Integer, Cell>> area = new HashMap<Integer, Map<Integer, Cell>>();

    public Field() {
        Map<Integer, Cell> startLine = new HashMap<Integer, Cell>();
        startLine.put(0, new Cell(PathStartCard.START_CARD));
        Map<Integer,Cell> finishLine = new HashMap<Integer, Cell>();
        area.put(0, startLine);

        List<Card> finishCards = PathFinishCard.FINISH_CARDS;
        finishLine.put(-1, new Cell(finishCards.get(0)));
        finishLine.put(0, new Cell(finishCards.get(1)));
        finishLine.put(1, new Cell(finishCards.get(2)));
        area.put(MINIMAL_DISTANCE + 1, finishLine);
    }

    //todo: add all needed checks and return true/false
    public boolean action(Card card, int x, int y) {
        Map<Integer, Cell> row = area.get(x);
        if (row == null) {
            row = new HashMap<Integer, Cell>();
            area.put(x, row);
        }
        Cell cell = row.get(y);
        if (cell == null) {
            cell = new Cell(card);
            row.put(y, cell);
        }
        cell.setCurrentCard(card);
        return true;
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