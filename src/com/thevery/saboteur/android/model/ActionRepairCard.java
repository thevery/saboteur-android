package com.thevery.saboteur.android.model;

import java.util.List;

//todo: player must choose one of repair ability in case of 2
public class ActionRepairCard extends ActionAbstractCard {
    private final List<Player.Tool> repairedTools;

    public ActionRepairCard(List<Player.Tool> repairedTools) {
        //todo: make defencive copy
        this.repairedTools = repairedTools;
    }

    public List<Player.Tool> getRepairedTools() {
        return repairedTools;
    }

    @Override
    public Card makeCopy() {
        return new ActionRepairCard(repairedTools);
    }
}
