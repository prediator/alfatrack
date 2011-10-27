package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

/**
 * @author Sergii Pogodin
 */
class FlushDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        return DefinerUtils.isTheSameSuit(hand.getCards());
    }
}
