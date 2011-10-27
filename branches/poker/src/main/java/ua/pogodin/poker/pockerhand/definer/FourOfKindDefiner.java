package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.areQuantitiesOfSameKind;

/**
 * @author Sergii Pogodin
 */
class FourOfKindDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        return areQuantitiesOfSameKind(hand, 4, 1);
    }

}
