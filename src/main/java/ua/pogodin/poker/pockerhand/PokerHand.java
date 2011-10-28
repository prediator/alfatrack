package ua.pogodin.poker.pockerhand;

/**
 * @author Sergii Pogodin
 */
public enum PokerHand {
    StraightFlush("straight-flush"),
    FourOfKind("four-of-a-kind"),
    FullHouse("full-house"),
    Flush("flush"),
    Straight("straight"),
    ThreeOfKind("three-of-a-kind"),
    TwoPair("two-pairs"),
    OnePair("one-pair"),
    HighCard("highest-card");

    private String description;

    private PokerHand(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
