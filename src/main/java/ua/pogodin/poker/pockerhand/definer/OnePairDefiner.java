package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.cards.Hand;

import java.util.List;

import static ua.pogodin.poker.pockerhand.definer.DefinerUtils.areQuantitiesOfSameKind;

/**
 * @author Sergii Pogodin
 */
class OnePairDefiner implements PokerHandDefiner {
    public boolean define(Hand hand) {
        List<Card> cards = hand.getCards();
        return areQuantitiesOfSameKind(cards, 2, 1, 1, 1) || areQuantitiesOfSameKind(cards, 3, 1, 1);
    }
}
