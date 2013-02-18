package com.thevery.saboteur.android.model;

import java.util.Arrays;
import java.util.List;

public abstract class ActionCard extends Card {
    enum Tool {
        PICK,
        LANTERN,
        TROLLEY
    }

    @Override
    public int getCount() {
        return 27;
    }

    //todo: player must choose one of repair ability in case of 2
    public static class RepairCard extends ActionCard {
        private final List<Tool> repairedTools;

        public RepairCard(Tool... repairedTools) {
            this.repairedTools = Arrays.asList(repairedTools);
        }

        public List<Tool> getRepairedTools() {
            return repairedTools;
        }
    }

    public static class BrakeCard extends ActionCard {
        private final Tool brokenTool;

        public BrakeCard(Tool brokenTool) {
            this.brokenTool = brokenTool;
        }

        public Tool getBrokenTool() {
            return brokenTool;
        }
    }
}
