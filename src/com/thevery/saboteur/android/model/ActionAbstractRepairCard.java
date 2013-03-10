package com.thevery.saboteur.android.model;

public abstract class ActionAbstractRepairCard extends ActionAbstractCard {
    public abstract boolean canRepair(Player.Tool tool);
}
