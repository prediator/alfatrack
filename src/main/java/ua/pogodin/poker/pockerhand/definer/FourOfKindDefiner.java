package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

import java.util.Arrays;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.calcSameRankCardsQuantities;

/**
 * @author Sergii Pogodin
 */
class FourOfKindDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        Integer[] quantities = calcSameRankCardsQuantities(hand.getCards());
        return Arrays.equals(quantities, new Integer[]{4, 1});
    }

}
