package ua.pogodin.poker.cards;

import org.apache.commons.lang.StringUtils;
import ua.pogodin.poker.card.Card;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Deck of five cards.
 */
public class Deck {
    private LinkedList<Card> cardList;

    public Deck(Collection<Card> cardList) {
        this.cardList = new LinkedList<Card>(cardList);
    }

    public Deck(Deck deck) {
        this(deck.cardList);
    }

    public static Deck parse(String string) {
        return new Deck(FiveCardsParser.parseFiveCards(string));
    }

    /**
     * get the top card. Remove it from the deck.
     * @return the top card
     */
    public Card poll() {
        return cardList.poll();
    }

    @Override
    public String toString() {
        return StringUtils.join(cardList, " ");
    }
}
