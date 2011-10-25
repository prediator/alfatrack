package ua.pogodin.poker.cards;

import org.apache.commons.lang.StringUtils;
import ua.pogodin.poker.card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Hand of 5 cards. Immutable.
 * Cards are stored ordered from strongest to weakest
 */
public class Hand {
    private Set<Card> cards;

    Hand(List<Card> fiveCards) {
        this.cards = new TreeSet<Card>(fiveCards);

        if (this.cards.size() != FiveCardsParser.FIVE) {
            throw new IllegalArgumentException("Not 5 unique cards: " + StringUtils.join(fiveCards, " "));
        }
    }

    public static Hand parse(String string) {
        return new Hand(FiveCardsParser.parseFiveCards(string));
    }

    /**
     * Return all 5 cards ordered from strongest to weakest
     * @return list of 5 cards
     */
    public List<Card> getCards() {
        return new ArrayList<Card>(cards);
    }

    @Override
    public String toString() {
        return StringUtils.join(cards, " ");
    }
}
