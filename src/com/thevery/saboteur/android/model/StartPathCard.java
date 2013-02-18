package com.thevery.saboteur.android.model;

public class StartPathCard extends PathCard {
    public static final Card START_CARD = new StartPathCard();

    private StartPathCard() {
        super(Way.AISLE, Way.AISLE, Way.AISLE, Way.AISLE);
    }
}
