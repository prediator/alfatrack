package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.cards.Hand;

/**
 * @author Sergii Pogodin
 */
public interface PokerHandDefiner {
    boolean define(Hand hand);
}
