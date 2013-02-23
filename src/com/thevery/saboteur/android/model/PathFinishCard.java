package com.thevery.saboteur.android.model;

import java.util.ArrayList;
import java.util.List;

public class PathFinishCard extends Card {
    public static final int TOTAL_COUNT = 3;
    public static final int GOLD_COUNT = 2;

    private final boolean empty;
    private boolean opened = false;

    public PathFinishCard(boolean empty) {
        this.empty = empty;
    }

    public boolean isOpened() {
        return opened;
    }

    public boolean isEmpty() {
        return empty;
    }

    public static List<Card> makeCards() {
        List<Card> cards = new ArrayList<Card>(TOTAL_COUNT);
        for (int i = 0; i < GOLD_COUNT; i++) {
            cards.add(new PathFinishCard(false));
        }
        for (int i = GOLD_COUNT; i < TOTAL_COUNT; i++) {
            cards.add(new PathFinishCard(true));
        }
        return cards;
    }
}
