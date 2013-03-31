package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.Player;
import com.thevery.saboteur.android.model.cards.PlayerTurnCard;

/**
 * Some turn that goes on some player, i.e. brake, repair or spy
 */
public class PlayerTurn extends Turn<PlayerTurnCard> {
    private Player player;

    public PlayerTurn(PlayerTurnCard card, Player player) {
        super(card);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return "card '" + getCard() + "' to player '" + player + "";
    }
}
