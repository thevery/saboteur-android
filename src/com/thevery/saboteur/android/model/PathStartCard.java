package com.thevery.saboteur.android.model;

public class PathStartCard extends PathCard {
    public static final Card START_CARD = new PathStartCard();

    private PathStartCard() {
        super(Way.AISLE, Way.AISLE, Way.AISLE, Way.AISLE);
    }
}