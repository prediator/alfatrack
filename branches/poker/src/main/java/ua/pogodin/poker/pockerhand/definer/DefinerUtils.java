package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;
import ua.pogodin.poker.card.Suit;
import ua.pogodin.poker.cards.Hand;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergii Pogodin
 */
@SuppressWarnings("JavaDoc")
class DefinerUtils {
    private DefinerUtils() {
    }

    /**
     * Find counts of cards of same rank.
     * For example:<br/>
     * AD, AS, AC -> {3}<br/>
     * 4D, JC, 4C, 5S, JH -> {2, 2, 1}
     * @param cards collection of cards
     * @return array of quantities
     */
    //todo review name and javadoc
    static Integer[] calcSameRankCardsQuantities(Collection<Card> cards) {
        Map<Rank, Integer> rankCountMap = new HashMap<Rank, Integer>(Rank.values().length);

        for (Card card : cards) {
            Integer count = rankCountMap.get(card.getRank());
            if (count == null) {
                count = 0;
            }
            rankCountMap.put(card.getRank(), ++count);
        }

        return sortedArrayOf(rankCountMap.values());
    }

    private static Integer[] sortedArrayOf(Collection<Integer> integers) {
        Integer[] array = integers.toArray(new Integer[integers.size()]);
        Arrays.sort(array, Collections.reverseOrder());
        return array;
    }

    //todo review name
    static boolean areQuantitiesOfSameKind(Hand hand, Integer... expectedQuantities) {
        Integer[] quantities = calcSameRankCardsQuantities(hand.getCards());
        return Arrays.equals(quantities, expectedQuantities);
    }


    static boolean isTheSameSuit(List<Card> cards) {
        Suit suit = cards.get(0).getSuit();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    /**
     * return true if A5432 or AKQJT or similar
     */
    static boolean isRankInARow(List<Card> cards) {
        return isRankTop4HigherThenRankBottom(cards) || isTopAceAndFive(cards);
    }

    /**
     * return true if AKQJT or similar
     */
    private static boolean isRankTop4HigherThenRankBottom(List<Card> cards) {
        return cards.get(4).getRank().ordinal() - cards.get(0).getRank().ordinal() == 4;
    }

    /**
     * return true if A5432
     */
    private static boolean isTopAceAndFive(List<Card> cards) {
        return cards.get(0).getRank() == Rank.Ace && cards.get(1).getRank() == Rank.Five;
    }
}
