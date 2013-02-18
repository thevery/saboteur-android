package com.thevery.saboteur.android.model;

import android.util.SparseArray;

public class Field {
    public static final int MINIMAL_DISTANCE = 7;

    private final SparseArray<SparseArray<Cell>> area = new SparseArray<SparseArray<Cell>>();

    public Field() {
        SparseArray<Cell> initialArray = new SparseArray<Cell>();
        initialArray.put(0, new Cell(PathStartCard.START_CARD));
        area.put(0, initialArray);
    }

    //todo: add all needed checks and return true/false
    public boolean action(Card card, int x, int y) {
        SparseArray<Cell> row = area.get(x);
        if (row == null) {
            row = new SparseArray<Cell>();
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