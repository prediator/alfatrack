package ua.pogodin.poker.card;

public enum Kind {
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

    Kind(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public static Kind parse(String abbreviation) {
        for (Kind kind : Kind.values()) {
            if (kind.abbreviation.equalsIgnoreCase(abbreviation)) {
                return kind;
            }
        }
        throw new IllegalArgumentException(String.format("No kind for \"%s\"", abbreviation));
    }
}
