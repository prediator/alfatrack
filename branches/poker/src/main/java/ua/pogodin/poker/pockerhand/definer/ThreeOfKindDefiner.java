package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

/**
 * @author Sergii Pogodin
 */
class ThreeOfKindDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        return DefinerUtils.areQuantitiesOfSameKind(hand.getCards(), 3, 1, 1);
    }
}
