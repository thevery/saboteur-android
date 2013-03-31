package com.thevery.saboteur.android.model.cards;

//todo: some card and non-symmetric so we should either ask player to rotate or rotate automatically
public class PathCard implements FieldTurnCard {
    private final Way top;
    private final Way right;
    private final Way bottom;
    private final Way left;

    public enum Way {
        EMPTY,
        AISLE,
        DEADLOCK
    }

    public PathCard(Way top, Way right, Way bottom, Way left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    @Override
    public Card makeCopy() {
        return new PathCard(top, right, bottom, left);
    }
}
