package ua.pogodin.poker.pockerhand.definer;

import ua.pogodin.poker.pockerhand.PokerHand;

/**
 * @author Sergii Pogodin
 */
public class PokerHandDefinerFactory {
    public static PokerHandDefiner createDefiner(PokerHand pokerHand) {
        switch (pokerHand) {
            case StraightFlush:
                return new StraightFlushDefiner();
            case FourOfKind:
                return new FourOfKindDefiner();
            case FullHouse:
                return new FullHouseDefiner();
            case Flush:
                return new FlushDefiner();
            case Straight:
                return new StraightDefiner();
            case ThreeOfKind:
                return new ThreeOfKindDefiner();
            case TwoPair:
                return new TwoPairDefiner();
            case OnePair:
                return new OnePairDefiner();
            case HighCard:
                return new HighCardDefiner();
        }
        throw new IllegalArgumentException("No definer for PokerHand " + pokerHand);
    }
}
