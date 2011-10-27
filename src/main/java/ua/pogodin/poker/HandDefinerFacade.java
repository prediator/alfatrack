package ua.pogodin.poker;

import ua.pogodin.poker.cards.Hand;
import ua.pogodin.poker.cards.HandAndDeck;
import ua.pogodin.poker.pockerhand.PokerHand;
import ua.pogodin.poker.pockerhand.definer.PokerHandDefinerFactory;

/**
 * @author Sergii Pogodin
 */
public class HandDefinerFacade {
    public PokerHand define(HandAndDeck handAndDeck) {
        for (PokerHand pokerHand : PokerHand.values()) {
            for (Hand hand : handAndDeck.getAllPossibleHands()) {
                if (PokerHandDefinerFactory.createDefiner(pokerHand).define(hand)) {
                    return pokerHand;
                }
            }
        }
        throw new RuntimeException("No-no-no, David Blaine, no more street magic!"); // is never thrown
    }
}
