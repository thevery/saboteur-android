package com.thevery.saboteur.android.model;

public class DistributionHelper {
    private final int players;

    public DistributionHelper(int players) {
        if (players < 3 || players > 10) {
            throw new IllegalArgumentException("players count must be from 3 to 10!");
        }
        this.players = players;
    }

    public int getCardsPerPlayer() {
        if (players <= 5) return 6;
        if (players >= 7) return 5;
        return 4;
    }
}
