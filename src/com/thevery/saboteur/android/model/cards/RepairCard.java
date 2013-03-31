package com.thevery.saboteur.android.model.cards;

import com.thevery.saboteur.android.model.Player;

import java.util.Arrays;
import java.util.List;

public class RepairCard implements PlayerTurnCard {
    private List<Player.Tool> repairedTools;
    private Player.Tool repairedTool;

    public RepairCard(Player.Tool... repairedTools) {
        this.repairedTools = Arrays.asList(repairedTools);
        if (repairedTools.length == 1) {
            repairedTool = repairedTools[0];
        }
    }

    public Player.Tool getRepairedTool() {
        return repairedTool;
    }

    public void setRepairedTool(Player.Tool repairedTool) {
        //todo: check
        this.repairedTool = repairedTool;
    }

    public boolean canRepair(Player.Tool tool) {
        return repairedTools.contains(tool);
    }

    @Override
    public Card makeCopy() {
        return new RepairCard(repairedTools.toArray(new Player.Tool[repairedTools.size()]));
    }
}
