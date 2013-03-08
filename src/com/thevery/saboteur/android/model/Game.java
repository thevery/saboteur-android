package com.thevery.saboteur.android.model;

import java.util.*;

import static com.thevery.saboteur.android.model.PathCard.Way.AISLE;
import static com.thevery.saboteur.android.model.PathCard.Way.DEADLOCK;
import static com.thevery.saboteur.android.model.PathCard.Way.EMPTY;

public class Game {
    private final int playersCount;
    private final Field field;
    private final Map<Integer, List<Card>> playerCards;
    private final Stack<Card> deck = new Stack<Card>();

    public Game(int playersCount) {
        this.playersCount = playersCount;
        field = new Field();
        playerCards = new HashMap<Integer, List<Card>>(playersCount);
        InitialDistributionHelper helper = new InitialDistributionHelper(playersCount);
        fillDeck();
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

    //http://cf.geekdo-images.com/images/pic180040_md.jpg
    private Stack<Card> fillDeck() {
        if (!deck.empty()) throw new IllegalStateException("cannot fill one deck twice!");
        fill(new PathCard(AISLE, EMPTY, AISLE, EMPTY), 4);
        fill(new PathCard(AISLE, AISLE, AISLE, EMPTY), 5);
        fill(new PathCard(AISLE, AISLE, AISLE, AISLE), 5);
        fill(new PathCard(EMPTY, AISLE, AISLE, EMPTY), 4);
        fill(new PathCard(EMPTY, EMPTY, AISLE, AISLE), 5);
        fill(new PathCard(EMPTY, EMPTY, DEADLOCK, EMPTY), 1);
        fill(new PathCard(DEADLOCK, EMPTY, DEADLOCK, DEADLOCK), 1);
        fill(new PathCard(DEADLOCK, DEADLOCK, DEADLOCK, DEADLOCK), 1);
        fill(new PathCard(EMPTY, DEADLOCK, DEADLOCK, EMPTY), 1);
        fill(new PathCard(EMPTY, EMPTY, DEADLOCK, DEADLOCK), 1);
        fill(new PathCard(EMPTY, EMPTY, EMPTY, DEADLOCK), 1);
        fill(new PathCard(AISLE, AISLE, EMPTY, AISLE), 5);
        fill(new PathCard(EMPTY, AISLE, EMPTY, AISLE), 3);
        fill(new PathCard(DEADLOCK, EMPTY, DEADLOCK, EMPTY), 1);
        fill(new PathCard(DEADLOCK, DEADLOCK, EMPTY, DEADLOCK), 1);
        fill(new PathCard(EMPTY, DEADLOCK, EMPTY, DEADLOCK), 1);

        Collections.shuffle(deck);
        return deck;
    }

    private void fill(Card card, int count) {
        for (int i = 0; i < count; i++) {
            deck.add(card.makeCopy());
        }
    }
}
