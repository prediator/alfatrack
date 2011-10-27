package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.isTheSameSuit;

/**
 * @author Sergii Pogodin
 */
class FlushDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        return isTheSameSuit(hand.getCards());
    }
}
