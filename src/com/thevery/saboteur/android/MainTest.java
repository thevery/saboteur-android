package com.thevery.saboteur.android;

import com.thevery.saboteur.android.model.*;
import com.thevery.saboteur.android.model.cards.*;
import com.thevery.saboteur.android.model.turn.FieldTurn;
import com.thevery.saboteur.android.model.turn.PlayerTurn;
import com.thevery.saboteur.android.model.turn.SkipTurn;
import com.thevery.saboteur.android.model.turn.Turn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainTest {
    public static final int PLAYERS_COUNT = 6;

    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>(PLAYERS_COUNT);
        Game game = new Game(PLAYERS_COUNT);
        Field field = game.getField();
        Stack<Card> deck = game.getDeck();

        for (int i = 0; i < PLAYERS_COUNT; i++) {
            List<Card> cards = game.getCardsForPlayer(i);
            Player player = new Player(game.getRoleForPlayer(i));
            player.setCards(cards);
            players.add(player);
        }

        for (int i = 0; i < PLAYERS_COUNT; i++) {
            Player currentPlayer = players.get(i);
            if (currentPlayer.hasCards()) {
                //todo: check if player can make FieldTurn 'positive' turn - nothing is broken
                Turn turn = currentPlayer.makeTurn();
                if (turn instanceof FieldTurn) {
                    FieldTurn fieldTurn = (FieldTurn) turn;
                    field.turn(fieldTurn.getCard(), fieldTurn.getX(), fieldTurn.getY());
                } else if (turn instanceof PlayerTurn) {
                    PlayerTurn playerTurn = (PlayerTurn) turn;
                    Player player = playerTurn.getPlayer();
                    PlayerTurnCard card = playerTurn.getCard();
                    if (card instanceof RepairCard) {
                        RepairCard repairCard = (RepairCard) card;
                        player.repairTool(repairCard.getRepairedTool());
                    } else if (card instanceof BrakeCard) {
                        BrakeCard brakeCard = (BrakeCard) card;
                        player.breakTool(brakeCard.getBrokenTool());
                    } else if (card instanceof SpyCard) {
                        //todo
                        Player.Role role = player.getRole((SpyCard) card);
                    }
                } else if (turn instanceof SkipTurn) {
                    //does nothing
                }
                if (!deck.empty()) {
                    currentPlayer.addCard(deck.pop());
                }
            } else {
                //todo: check if games is finished
            }
        }


    }
}
