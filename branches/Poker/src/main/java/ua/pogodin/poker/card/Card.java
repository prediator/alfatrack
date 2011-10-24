package ua.pogodin.poker.card;

public class Card implements Comparable<Card> {
    private Kind kind;
    private Suit suit;

    public Card(Kind kind, Suit suit) {
        this.kind = kind;
        this.suit = suit;
    }

    public static Card parse(String string) {
        if (string == null || string.length() != 2) {
            throw new IllegalArgumentException(String.format("Can't parse card \"%s\"", string));
        }
        return new Card(Kind.parse(string.substring(0, 1)), Suit.parse(string.substring(1, 2)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return kind == card.kind && suit == card.suit;
    }

    public int compareTo(Card other) {
        int comparison = this.kind.compareTo(other.kind);
        return comparison != 0 ? comparison : this.suit.compareTo(other.suit);
    }
}
