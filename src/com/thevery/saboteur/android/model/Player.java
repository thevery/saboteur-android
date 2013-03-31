package com.thevery.saboteur.android.model;

import com.thevery.saboteur.android.model.cards.*;
import com.thevery.saboteur.android.model.turn.SkipTurn;
import com.thevery.saboteur.android.model.turn.Turn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final Set<Tool> brokenTools = new HashSet<Tool>();
    private List<Card> cards;
    private Role role;

    public Player(Role role) {
        this.role = role;
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
        //todo
        return new SkipTurn(cards.get(0));
    }

    public Role getRole(SpyCard card) {
        return role;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean hasCards() {
        return cards.isEmpty();
    }

    public static enum Tool {
        PICK,
        LANTERN,
        TROLLEY
    }

    public static enum Role {
        DWARF,
        SABOTEUR
    }
}
