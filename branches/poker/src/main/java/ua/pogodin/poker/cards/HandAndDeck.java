package ua.pogodin.poker.cards;

import java.util.Iterator;

import static ua.pogodin.poker.cards.CardsParserUtil.FIVE_CARD_ABBREVIATIONS_LENGTH;

/**
 * @author Sergii Pogodin
 */
public class HandAndDeck {
    public static final int TEN_CARD_ABBREVIATIONS_LENGTH = 29;

    Hand hand;
    Deck deck;

    public HandAndDeck(Hand hand, Deck deck) {
        this.hand = hand;
        this.deck = deck;
    }

    public static HandAndDeck parse(String string) {
        if (string == null || string.length() != TEN_CARD_ABBREVIATIONS_LENGTH) {
            throw new IllegalArgumentException(String.format("Can't parse ten cards \"%s\"", string));
        }

        return new HandAndDeck(Hand.parse(string.substring(0, FIVE_CARD_ABBREVIATIONS_LENGTH)),
                Deck.parse(string.substring(FIVE_CARD_ABBREVIATIONS_LENGTH + 1, TEN_CARD_ABBREVIATIONS_LENGTH)));
    }

    @Override
    public String toString() {
        return "Hand: " + hand + " Deck: " + deck;
    }

    public Iterable<Hand> getAllPossibleHands() {
        return new Iterable<Hand>() {
            public Iterator<Hand> iterator() {
                return new HandAndDeckIterator(HandAndDeck.this);
            }
        };
    }
}