package ua.pogodin.poker.card;

public enum Suit {
    Spades("S"),
    Hearts("H"),
    Diamonds("D"),
    Clubs("C");

    private String abbreviation;

    Suit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Suit parse(String abbreviation) {
        for (Suit suit : Suit.values()) {
            if (suit.abbreviation.equalsIgnoreCase(abbreviation)) {
                return suit;
            }
        }
        throw new IllegalArgumentException(String.format("No suite for \"%s\"", abbreviation));
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
