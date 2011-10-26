package ua.pogodin.poker.cards;

import ua.pogodin.poker.card.Card;

import java.util.Iterator;
import java.util.List;

/**
 * @author Sergii Pogodin
 */
class HandAndDeckIterator implements Iterator<Hand> {
    private static final int ALL_BITS_0 = 0;  // last 5 bits are 00000
    private static final int ALL_BITS_1 = 31; // last 5 bits are 11111

    private static final int[] SEMAPHORES = new int[] {
            16, //10000
            8,  //01000
            4,  //00100
            2,  //00010
            1   //00001
    };

    private HandAndDeck handAndDeck;
    private int cardsToReplace;

    public HandAndDeckIterator(HandAndDeck handAndDeck) {
        this.handAndDeck = handAndDeck;
        cardsToReplace = ALL_BITS_0;
    }

    public boolean hasNext() {
        return cardsToReplace <= ALL_BITS_1;
    }

    public Hand next() {
        List<Card> cards = handAndDeck.hand.getCards();

        Deck deck = new Deck(handAndDeck.deck);

        for (int i = 0; i < SEMAPHORES.length; i++) {
            if ((cardsToReplace & SEMAPHORES[i]) != 0) {
                cards.set(i, deck.poll());
            }
        }

        Hand hand = new Hand(cards);
        cardsToReplace++;
        return hand;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
