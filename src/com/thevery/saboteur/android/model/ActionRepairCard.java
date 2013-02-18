package com.thevery.saboteur.android.model;

import java.util.Arrays;
import java.util.List;

//todo: player must choose one of repair ability in case of 2
public class ActionRepairCard extends ActionAbstractCard {
    //todo: maybe array fo two instead of list
    private final List<Player.Tool> repairedTools;

    public ActionRepairCard(Player.Tool... repairedTools) {
        this.repairedTools = Arrays.asList(repairedTools);
    }

    public List<Player.Tool> getRepairedTools() {
        return repairedTools;
    }
}
