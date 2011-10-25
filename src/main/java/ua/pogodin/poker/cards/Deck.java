package ua.pogodin.poker.cards;

import org.apache.commons.lang.StringUtils;
import ua.pogodin.poker.card.Card;

import java.util.Collections;
import java.util.List;

/**
 * Deck of five cards. Immutable.
 */
public class Deck {
    private List<Card> cardList;

    Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public static Deck parse(String string) {
        return new Deck(FiveCardsParser.parseFiveCards(string));
    }

    /**
     * Return several cards from the top. The hand remains not changed.
     * @param cardsNumber cards number to pull
     * @return list of cards from the hand of number specified
     */
    public List<Card> pull(int cardsNumber) {
        return cardList.subList(0, cardsNumber);
    }

    @Override
    public String toString() {
        return StringUtils.join(cardList, " ");
    }
}
