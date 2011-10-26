package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;
import ua.pogodin.poker.card.Suit;
import ua.pogodin.poker.cards.Hand;

import java.util.List;

/**
 * @author Sergii Pogodin
 */
@SuppressWarnings("JavaDoc")
class StraightFlushDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        List<Card> cards = hand.getCards();
        return isTheSameSuit(cards) && isRankInARow(cards);
    }

    private boolean isTheSameSuit(List<Card> cards) {
        Suit suit = cards.get(0).getSuit();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    /**
     * return true if A5432, AKQJT or similar
     */
    private boolean isRankInARow(List<Card> cards) {
        return isRankTop4HigherThenRankBottom(cards) || isTopAceAndFive(cards);
    }

    /**
     * return true if AKQJT or similar
     */
    private boolean isRankTop4HigherThenRankBottom(List<Card> cards) {
        return cards.get(4).getRank().ordinal() - cards.get(0).getRank().ordinal() == 4;
    }

    /**
     * return true if A5432
     */
    private boolean isTopAceAndFive(List<Card> cards) {
        return cards.get(0).getRank() == Rank.Ace && cards.get(1).getRank() == Rank.Five;
    }

}
