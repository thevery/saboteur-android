package com.thevery.saboteur.android.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//todo: some card and non-symmetric so we should either ask player to rotate or rotate automatically
public class PathCard extends Card {
    public static final int TOTAL_CARDS = 40;
    public static final int STATE_COUNT = Way.values().length;

    enum Way {
        EMPTY,
        AISLE,
        DEADLOCK
    }

    private final Way left;
    private final Way right;
    private final Way top;
    private final Way bottom;

    public PathCard(Way left, Way right, Way top, Way bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    //todo: totally wrong algo, must be improved
    private static Card makeRandomCard(Random random) {
        Way[] values = Way.values();
        return new PathCard(values[random.nextInt(STATE_COUNT)], values[random.nextInt(STATE_COUNT)],
                values[random.nextInt(STATE_COUNT)], values[random.nextInt(STATE_COUNT)]);
    }

    public static List<Card> makeInitialCards() {
        Random random = new Random();
        List<Card> cards = new ArrayList<Card>(TOTAL_CARDS);
        for (int i = 0; i < TOTAL_CARDS; i++) {
            cards.add(makeRandomCard(random));
        }
        return cards;
    }
}