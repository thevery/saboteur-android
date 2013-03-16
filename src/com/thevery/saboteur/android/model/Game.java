package com.thevery.saboteur.android.model;

import com.thevery.saboteur.android.model.cards.*;
import com.thevery.saboteur.android.model.util.InitialDistributionHelper;

import java.util.*;

import static com.thevery.saboteur.android.model.cards.PathCard.Way.AISLE;
import static com.thevery.saboteur.android.model.cards.PathCard.Way.DEADLOCK;
import static com.thevery.saboteur.android.model.cards.PathCard.Way.EMPTY;
import static com.thevery.saboteur.android.model.Player.Tool.LANTERN;
import static com.thevery.saboteur.android.model.Player.Tool.PICK;
import static com.thevery.saboteur.android.model.Player.Tool.TROLLEY;

public class Game {
    private final int playersCount;
    private final Field field;
    private final Map<Integer, List<Card>> playerCards;
    private final Stack<Card> deck;

    public Game(int playersCount) {
        this.playersCount = playersCount;
        field = new Field();
        playerCards = new HashMap<Integer, List<Card>>(playersCount);
        deck = makeInitialDeck();
        InitialDistributionHelper helper = new InitialDistributionHelper(playersCount);
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
    private Stack<Card> makeInitialDeck() {
        FillStack deck = new FillStack();
        deck.fill(new PathCard(AISLE, EMPTY, AISLE, EMPTY), 4);
        deck.fill(new PathCard(AISLE, AISLE, AISLE, EMPTY), 5);
        deck.fill(new PathCard(AISLE, AISLE, AISLE, AISLE), 5);
        deck.fill(new PathCard(EMPTY, AISLE, AISLE, EMPTY), 4);
        deck.fill(new PathCard(EMPTY, EMPTY, AISLE, AISLE), 5);
        deck.fill(new PathCard(EMPTY, EMPTY, DEADLOCK, EMPTY), 1);
        deck.fill(new PathCard(DEADLOCK, EMPTY, DEADLOCK, DEADLOCK), 1);
        deck.fill(new PathCard(DEADLOCK, DEADLOCK, DEADLOCK, DEADLOCK), 1);
        deck.fill(new PathCard(EMPTY, DEADLOCK, DEADLOCK, EMPTY), 1);
        deck.fill(new PathCard(EMPTY, EMPTY, DEADLOCK, DEADLOCK), 1);
        deck.fill(new PathCard(EMPTY, EMPTY, EMPTY, DEADLOCK), 1);
        deck.fill(new PathCard(AISLE, AISLE, EMPTY, AISLE), 5);
        deck.fill(new PathCard(EMPTY, AISLE, EMPTY, AISLE), 3);
        deck.fill(new PathCard(DEADLOCK, EMPTY, DEADLOCK, EMPTY), 1);
        deck.fill(new PathCard(DEADLOCK, DEADLOCK, EMPTY, DEADLOCK), 1);
        deck.fill(new PathCard(EMPTY, DEADLOCK, EMPTY, DEADLOCK), 1);
        deck.fill(new ActionBrakeCard(TROLLEY), 3);
        deck.fill(new ActionBrakeCard(LANTERN), 3);
        deck.fill(new ActionBrakeCard(PICK), 3);
        deck.fill(new ActionSpyCard(), 6);
        deck.fill(new ActionBoomCard(), 3);
        deck.fill(new ActionSingeRepairCard(TROLLEY), 2);
        deck.fill(new ActionSingeRepairCard(LANTERN), 2);
        deck.fill(new ActionSingeRepairCard(PICK), 2);
        deck.fill(new ActionDoubleRepairCard(PICK, TROLLEY), 1);
        deck.fill(new ActionDoubleRepairCard(LANTERN, TROLLEY), 1);
        deck.fill(new ActionDoubleRepairCard(PICK, LANTERN), 1);
        Collections.shuffle(deck);
        return deck;
    }

    public Field getField() {
        return field;
    }

    private static class FillStack extends Stack<Card> {
        public void fill(Card card, int count) {
            for (int i = 0; i < count; i++) {
                add(card.makeCopy());
            }
        }
    }

}
