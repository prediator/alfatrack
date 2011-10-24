package ua.pogodin.poker.cards;

import ua.pogodin.poker.card.Card;

import java.util.Set;
import java.util.TreeSet;

public class Hand {
    private Set<Card> cards = new TreeSet<Card>();

    public static Hand parse(String string) {
        Hand hand = new Hand();
        hand.cards = new TreeSet<Card>(FiveCardsParser.parseFiveCards(string));

        if (hand.cards.size() != FiveCardsParser.FIVE) {
            throw new IllegalArgumentException("Cards duplication.");
        }
        return hand;
    }
}
