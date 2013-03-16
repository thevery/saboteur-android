package com.thevery.saboteur.android;

import com.thevery.saboteur.android.model.*;
import com.thevery.saboteur.android.model.cards.Card;
import com.thevery.saboteur.android.model.turn.FieldTurn;
import com.thevery.saboteur.android.model.turn.PlayerTurn;
import com.thevery.saboteur.android.model.turn.Turn;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static final int PLAYERS_COUNT = 6;

    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>(PLAYERS_COUNT);
        Game game = new Game(PLAYERS_COUNT);
        Field field = game.getField();
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            List<Card> cards = game.getCardsForPlayer(i);
            Player player = new Player();
            player.setCards(cards);
            players.add(player);
        }

        for (int i = 0; i < PLAYERS_COUNT; i++) {
            Player currentPlayer = players.get(i);
            Turn turn = currentPlayer.makeTurn();
            if (turn instanceof FieldTurn) {
                FieldTurn fieldTurn = (FieldTurn) turn;
                field.turn(fieldTurn.getCard(), fieldTurn.getX(), fieldTurn.getY());
            } else if (turn instanceof PlayerTurn) {
                PlayerTurn playerTurn = (PlayerTurn) turn;
                Player player = playerTurn.getPlayer();
                player.takeTurn(playerTurn.getCard());
            }
        }


    }
}
