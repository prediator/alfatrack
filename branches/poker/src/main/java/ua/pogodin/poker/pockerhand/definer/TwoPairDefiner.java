package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.areQuantitiesOfSameKind;

/**
 * @author Sergii Pogodin
 */
class TwoPairDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        return areQuantitiesOfSameKind(hand.getCards(), 2, 2, 1);
    }
}
