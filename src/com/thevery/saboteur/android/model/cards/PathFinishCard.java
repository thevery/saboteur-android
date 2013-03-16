package com.thevery.saboteur.android.model.cards;

import java.util.ArrayList;
import java.util.List;

public class PathFinishCard extends Card {
    public static final int TOTAL_COUNT = 3;
    public static final int GOLD_COUNT = 1;

    public static final Card EMPTY_CARD = new PathFinishCard(true);
    public static final Card GOLD_CARD = new PathFinishCard(false);

    public static final List<Card> FINISH_CARDS = new ArrayList<Card>();
    static {
        for (int i = 0; i < GOLD_COUNT; i++) {
            FINISH_CARDS.add(GOLD_CARD.makeCopy());
        }
        for (int i = GOLD_COUNT; i < TOTAL_COUNT; i++) {
            FINISH_CARDS.add(EMPTY_CARD.makeCopy());
        }
    }

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

    @Override
    public PathFinishCard makeCopy() {
        return new PathFinishCard(empty);
    }
}
