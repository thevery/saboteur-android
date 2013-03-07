package com.thevery.saboteur.android.model;

import java.util.Collections;
import java.util.Stack;

public class InitialDistributionHelper {
    private final int players;
    private Stack<Card> deck;

    public InitialDistributionHelper(int players) {
        if (players < 3 || players > 10) {
            throw new IllegalArgumentException("players count must be from 3 to 10!");
        }
        this.players = players;
        deck = new Stack<Card>();
        deck.addAll(PathCard.makeInitialCards());
        deck.addAll(ActionAbstractCard.makeInitialCards());
        Collections.shuffle(deck);
    }

    public int getCardsCountPerPlayer() {
        if (players <= 5) return 6;
        if (players >= 7) return 5;
        return 4;
    }

    public Stack<Card> getDeck() {
        return deck;
    }
}
