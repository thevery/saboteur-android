package com.thevery.saboteur.android.model.cards;

public class PathStartCard extends PathCard {
    public static final PathStartCard START_CARD = new PathStartCard();

    private PathStartCard() {
        super(Way.AISLE, Way.AISLE, Way.AISLE, Way.AISLE);
    }
}
