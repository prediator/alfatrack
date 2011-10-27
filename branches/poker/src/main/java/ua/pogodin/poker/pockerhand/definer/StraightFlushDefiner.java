package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.cards.Hand;

import java.util.List;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.isRankInARow;
import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.isTheSameSuit;

/**
 * @author Sergii Pogodin
 */
class StraightFlushDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        List<Card> cards = hand.getCards();
        return isTheSameSuit(cards) && isRankInARow(cards);
    }
}
