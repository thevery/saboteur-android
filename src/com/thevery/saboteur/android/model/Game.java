package com.thevery.saboteur.android.model;

import java.util.*;

public class Game {
    private final int playersCount;
    private final Field field;
    private final Map<Integer, List<Card>> playerCards;

    public Game(int playersCount) {
        this.playersCount = playersCount;
        field = new Field();
        playerCards = new HashMap<Integer, List<Card>>(playersCount);
        InitialDistributionHelper helper = new InitialDistributionHelper(playersCount);
        Stack<Card> deck = helper.getDeck();
        int cardsCountPerPlayer = helper.getCardsCountPerPlayer();
        for (int i = 0; i < cardsCountPerPlayer; i++) {
            for (int j = 0; j < playersCount; j++) {
                if (!playerCards.containsKey(j)) {
                    playerCards.put(j, new ArrayList<Card>(cardsCountPerPlayer));
                }
                List<Card> cards = playerCards.get(j);
                cards.add(deck.pop());
            }
        }
    }

    public List<Card> getCardsForPlayer(int playerNumber) {
        return playerCards.get(playerNumber);
    }

    public boolean isFinished() {
        return false;
    }

}
