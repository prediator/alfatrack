package ua.pogodin.poker.cards;

import ua.pogodin.poker.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Pogodin
 */
class CardsParserUtil {
    public static final int FIVE_CARD_ABBREVIATIONS_LENGTH = 14;
    public static final int FIVE = 5;

    private CardsParserUtil() {
    }

    protected static List<Card> parseFiveCards(String abbreviations) {
        if (abbreviations == null || abbreviations.length() != FIVE_CARD_ABBREVIATIONS_LENGTH) {
            throw new IllegalArgumentException(String.format("Can't parse five cards \"%s\". Wrong length.",
                    abbreviations));
        }

        String[] split = abbreviations.split(" ");
        if (split.length != FIVE) {
            throw new IllegalArgumentException(String.format("Can't parse five cards \"%s\". Wrong parts number: %d",
                    abbreviations, split.length));
        }

        List<Card> list = new ArrayList<Card>(FIVE);
        for (String abbreviation : split) {
            list.add(Card.parse(abbreviation));
        }
        return list;
    }
}
