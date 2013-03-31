package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.Player;
import com.thevery.saboteur.android.model.cards.ActionAbstractPlayerCard;

/**
 * Some turn that goes on some player, i.e. brake, repair or spy
 */
public class PlayerTurn extends Turn {
    private ActionAbstractPlayerCard card;
    private Player player;

    public PlayerTurn(ActionAbstractPlayerCard card, Player player) {
        this.card = card;
        this.player = player;
    }

    public ActionAbstractPlayerCard getCard() {
        return card;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "card '" + card + "' to player '" + player + "";
    }
}
