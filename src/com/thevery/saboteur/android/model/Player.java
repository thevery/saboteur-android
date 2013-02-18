package com.thevery.saboteur.android.model;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Set<ActionCard.Tool> brokenTools = new HashSet<ActionCard.Tool>();

    public Player() {
    }

    public boolean breakTool(ActionCard.Tool tool) {
        return brokenTools.add(tool);
    }

    public boolean repairTool(ActionCard.Tool tool) {
        return brokenTools.remove(tool);
    }
}
