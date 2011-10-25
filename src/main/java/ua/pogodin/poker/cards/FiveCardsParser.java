package ua.pogodin.poker.cards;

import ua.pogodin.poker.card.Card;

import java.util.ArrayList;
import java.util.List;

public class FiveCardsParser {
    public static final int FIVE_CARD_ABBREVIATIONS_LENGTH = 14;
    public static final int FIVE = 5;

    private FiveCardsParser() {
    }

    protected static List<Card> parseFiveCards(String abbreviations) {
        if (abbreviations == null || abbreviations.length() != FIVE_CARD_ABBREVIATIONS_LENGTH) {
            throw new IllegalArgumentException(String.format("Can't parse five cards \"%s\". Wrong length.",
                    abbreviations));
        }

        String[] splitted = abbreviations.split(" ");
        if (splitted.length != FIVE) {
            throw new IllegalArgumentException(String.format("Can't parse five cards \"%s\". Wrong parts number: %d",
                    abbreviations, splitted.length));
        }

        List<Card> list = new ArrayList<Card>(FIVE);
        for (String abbreviation : splitted) {
            list.add(Card.parse(abbreviation));
        }
        return list;
    }
}
