package com.thevery.saboteur.android.model;

import java.util.ArrayList;
import java.util.List;

public abstract class ActionAbstractCard extends Card {
    public static final int TOTAL_COUNT = 27;

    public static List<Card> makeInitialCards() {
        List<Card> cards = new ArrayList<Card>(TOTAL_COUNT);
        for (int i = 0; i < ActionBoomCard.TOTAL_COUNT; i++) {
            cards.add(new ActionBoomCard());
        }
        for (int i = 0; i < ActionBrakeCard.TOTAL_COUNT; i++) {
//            cards.add(new ActionBrakeCard());
        }
        return cards;
    }
}
