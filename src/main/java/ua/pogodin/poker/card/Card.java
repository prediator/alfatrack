package ua.pogodin.poker.card;

/**
 * @author Sergii Pogodin
 */
public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public static Card parse(String string) {
        if (string == null || string.length() != 2) {
            throw new IllegalArgumentException(String.format("Can't parse card \"%s\"", string));
        }
        return new Card(Rank.parse(string.substring(0, 1)), Suit.parse(string.substring(1, 2)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = rank != null ? rank.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }

    public int compareTo(Card other) {
        int comparison = this.rank.compareTo(other.rank);
        return comparison != 0 ? comparison : this.suit.compareTo(other.suit);
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }
}
