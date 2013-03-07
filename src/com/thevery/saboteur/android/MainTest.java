package com.thevery.saboteur.android;

import com.thevery.saboteur.android.model.Card;
import com.thevery.saboteur.android.model.Game;
import com.thevery.saboteur.android.model.PathFinishCard;
import com.thevery.saboteur.android.model.PathStartCard;

import java.util.List;

public class MainTest {
    public static final int PLAYERS_COUNT = 6;

    public static void main(String[] args) {
        Game game = new Game(PLAYERS_COUNT);
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            List<Card> cards = game.getCardsForPlayer(i);
            System.out.println("cards = " + cards);
        }
//        System.out.println("finishCards = " + finishCards);
    }
}
