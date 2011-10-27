package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.isRankInARow;

/**
 * @author Sergii Pogodin
 */
class StraightDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        return isRankInARow(hand.getCards());
    }
}
