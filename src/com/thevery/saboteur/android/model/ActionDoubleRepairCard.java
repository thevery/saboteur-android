package com.thevery.saboteur.android.model;

//todo: player must choose one of repair ability in case of 2
public class ActionDoubleRepairCard extends ActionAbstractRepairCard {
    private final Player.Tool repairedTool1;
    private final Player.Tool repairedTool2;

    public ActionDoubleRepairCard(Player.Tool repairedTool1, Player.Tool repairedTool2) {
        this.repairedTool1 = repairedTool1;
        this.repairedTool2 = repairedTool2;
    }

    @Override
    public Card makeCopy() {
        return new ActionDoubleRepairCard(repairedTool1, repairedTool2);
    }

    @Override
    public boolean canRepair(Player.Tool tool) {
        return repairedTool1 == tool || repairedTool2 == tool;
    }
}
