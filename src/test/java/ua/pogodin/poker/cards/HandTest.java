package ua.pogodin.poker.cards;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;
import ua.pogodin.poker.card.Suit;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class HandTest {
    private Hand hand;

    @BeforeMethod
    public void setUp() throws Exception {
        hand = new Hand(Arrays.asList(
                new Card(Rank.King, Suit.Clubs),
                new Card(Rank.Four, Suit.Hearts),
                new Card(Rank.Eight, Suit.Spades),
                new Card(Rank.Seven, Suit.Clubs),
                new Card(Rank.Ace, Suit.Diamonds)
        ));
    }

    @Test
    public void getCardsShouldReturnOrderFromStrongest() throws Exception {
        List<Card> cards = hand.getCards();
        assertNotNull(cards);
        assertEquals(cards.size(), 5);
        assertEquals(cards.get(0), new Card(Rank.Ace, Suit.Diamonds));
        assertEquals(cards.get(1), new Card(Rank.King, Suit.Clubs));
        assertEquals(cards.get(2), new Card(Rank.Eight, Suit.Spades));
        assertEquals(cards.get(3), new Card(Rank.Seven, Suit.Clubs));
        assertEquals(cards.get(4), new Card(Rank.Four, Suit.Hearts));
    }

    @Test
    public void toStringShouldReturnAbbreviations() throws Exception {
        assertEquals(hand.toString(), "AD KC 8S 7C 4H");
    }

    @Test
    public void handsWithSameCardsShouldBeEqual() throws Exception {
        Hand other = new Hand(Arrays.asList(
                new Card(Rank.Ace, Suit.Diamonds),
                new Card(Rank.Four, Suit.Hearts),
                new Card(Rank.Seven, Suit.Clubs),
                new Card(Rank.King, Suit.Clubs),
                new Card(Rank.Eight, Suit.Spades)
        ));

        assertTrue(hand.equals(other));
    }
}
