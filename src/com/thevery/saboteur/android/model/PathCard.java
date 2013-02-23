package com.thevery.saboteur.android.model;

//todo: some card and non-symmetric so we should either ask player to rotate or rotate automatically
public class PathCard extends Card {
    public static final int TOTAL_CARDS = 44;

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
}
