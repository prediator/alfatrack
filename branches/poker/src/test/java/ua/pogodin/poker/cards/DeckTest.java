package ua.pogodin.poker.cards;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;
import ua.pogodin.poker.card.Suit;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergii Pogodin
 */
public class DeckTest {
    private Deck deck;

    @BeforeMethod
    public void setUp() throws Exception {
        deck = new Deck(Arrays.asList(
                new Card(Rank.Ten, Suit.Spades),
                new Card(Rank.Ace, Suit.Diamonds),
                new Card(Rank.Nine, Suit.Hearts),
                new Card(Rank.Five, Suit.Diamonds),
                new Card(Rank.Queen, Suit.Clubs)
        ));
    }

    @Test
    public void pulledCardsShouldBeFromTop() throws Exception {
        assertEquals(deck.poll(), new Card(Rank.Ten, Suit.Spades));
        assertEquals(deck.poll(), new Card(Rank.Ace, Suit.Diamonds));
    }

    @Test
    public void toStringShouldReturnAbbreviations() throws Exception {
        assertEquals(deck.toString(), "TS AD 9H 5D QC");
    }
}
