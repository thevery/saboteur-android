package com.thevery.saboteur.android.model.turn;

import com.thevery.saboteur.android.model.Player;
import com.thevery.saboteur.android.model.cards.PlayerTurnCard;

/**
 * Some turn that goes on some player, i.e. brake, repair or spy
 */
public class PlayerTurn extends Turn {
    private PlayerTurnCard card;
    private Player player;

    public PlayerTurn(PlayerTurnCard card, Player player) {
        this.card = card;
        this.player = player;
    }

    public PlayerTurnCard getCard() {
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
