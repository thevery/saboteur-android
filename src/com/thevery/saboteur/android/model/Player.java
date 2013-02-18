package com.thevery.saboteur.android.model;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Set<Tool> brokenTools = new HashSet<Tool>();

    public Player() {
    }

    public boolean breakTool(Tool tool) {
        return brokenTools.add(tool);
    }

    public boolean repairTool(Tool tool) {
        return brokenTools.remove(tool);
    }

    static enum Tool {
        PICK,
        LANTERN,
        TROLLEY
    }
}
