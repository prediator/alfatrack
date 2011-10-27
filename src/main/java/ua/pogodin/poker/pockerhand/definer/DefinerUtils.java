package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergii Pogodin
 */
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
}
