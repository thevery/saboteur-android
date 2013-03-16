package com.thevery.saboteur.android.model;

import com.thevery.saboteur.android.model.cards.ActionAbstractPlayerCard;
import com.thevery.saboteur.android.model.cards.Card;
import com.thevery.saboteur.android.model.turn.Turn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final Set<Tool> brokenTools = new HashSet<Tool>();
    private List<Card> cards;

    public Player() {
    }

    public boolean breakTool(Tool tool) {
        return brokenTools.add(tool);
    }

    public boolean repairTool(Tool tool) {
        return brokenTools.remove(tool);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Turn makeTurn() {
        return null;
    }

    public void takeTurn(ActionAbstractPlayerCard card) {
        //todo: spy, repair or break
    }

    public static enum Tool {
        PICK,
        LANTERN,
        TROLLEY
    }
}
