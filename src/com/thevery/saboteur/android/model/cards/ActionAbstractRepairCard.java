package com.thevery.saboteur.android.model.cards;

import com.thevery.saboteur.android.model.Player;

public abstract class ActionAbstractRepairCard extends ActionAbstractPlayerCard {
    public abstract boolean canRepair(Player.Tool tool);
}
