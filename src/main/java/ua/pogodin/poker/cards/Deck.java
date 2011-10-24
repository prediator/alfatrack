package ua.pogodin.poker.cards;

import ua.pogodin.poker.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * Deck of five cards. Immutable.
 */
public class Deck {
    private List<Card> cardList;

    public static Deck parse(String string) {
        Deck deck = new Deck();
        deck.cardList = FiveCardsParser.parseFiveCards(string);
        return deck;
    }

    /**
     * Return several cards from the top. The deck remains not changed.
     * @param cardsNumber cards number to pull
     * @return list of cards from the deck of number specified
     */
    public List<Card> pull(int cardsNumber) {
        return cardList.subList(0, cardsNumber);
    }
}
