package com.thevery.saboteur.android.model.util;

public class InitialDistributionHelper {
    private final int players;

    public InitialDistributionHelper(int players) {
        if (players < 3 || players > 10) {
            throw new IllegalArgumentException("players count must be from 3 to 10!");
        }
        this.players = players;
    }

    public int getCardsCountPerPlayer() {
        if (players <= 5) return 6;
        if (players >= 7) return 5;
        return 4;
    }

    public int getSaboteursCount() {
        if (players <= 4) return 1;
        if (players <= 6) return 2;
        if (players <= 9) return 3;
        return 0;
    }
}
