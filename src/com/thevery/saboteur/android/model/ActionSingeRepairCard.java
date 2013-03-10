package com.thevery.saboteur.android.model;

public class ActionSingeRepairCard extends ActionAbstractRepairCard {
    private Player.Tool repairedTool;

    public ActionSingeRepairCard(Player.Tool repairedTool) {
        this.repairedTool = repairedTool;
    }

    @Override
    public Card makeCopy() {
        return new ActionSingeRepairCard(repairedTool);
    }

    @Override
    public boolean canRepair(Player.Tool tool) {
        return repairedTool == tool;
    }
}
