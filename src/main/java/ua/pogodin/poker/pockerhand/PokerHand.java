package ua.pogodin.poker.pockerhand;

public enum PokerHand {
    StraightFlush("Straight flush"),
    FourOfKind("Four of a kind"),
    FullHouse("Full house"),
    Flush("Flush"),
    Straight("Straight"),
    ThreeOfKind("Three of a kind"),
    TwoPair("Two pair"),
    OnePair("One pair"),
    HighCard("High card");

    private String description;

    PokerHand(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
