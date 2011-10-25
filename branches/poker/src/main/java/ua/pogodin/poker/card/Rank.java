package ua.pogodin.poker.card;

public enum Rank {
    Ace("A"),
    King("K"),
    Queen("Q"),
    Jack("J"),
    Ten("T"),
    Nine("9"),
    Eight("8"),
    Seven("7"),
    Six("6"),
    Five("5"),
    Four("4"),
    Three("3"),
    Two("2");

    private String abbreviation;

    Rank(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Rank parse(String abbreviation) {
        for (Rank rank : Rank.values()) {
            if (rank.abbreviation.equalsIgnoreCase(abbreviation)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(String.format("No kind for \"%s\"", abbreviation));
    }

    @Override
    public String toString() {
        return abbreviation;
    }
}
