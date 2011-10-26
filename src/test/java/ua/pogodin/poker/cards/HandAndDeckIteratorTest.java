package ua.pogodin.poker.cards;

import org.apache.commons.collections.CollectionUtils;
import org.testng.annotations.Test;
import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;
import ua.pogodin.poker.card.Suit;

import java.util.Arrays;
import java.util.HashSet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class HandAndDeckIteratorTest {

    @Test
    public void iteratorIteratesThrough32uniqueHands() throws Exception {
        HandAndDeck handAndDeck = new HandAndDeck( //3D 5S 2H QD TD 6S KH 9H AD QH
                new Hand(Arrays.asList(
                        new Card(Rank.Three, Suit.Diamonds),
                        new Card(Rank.Five, Suit.Spades),
                        new Card(Rank.Two, Suit.Hearts),
                        new Card(Rank.Queen, Suit.Diamonds),
                        new Card(Rank.Ten, Suit.Diamonds)
                )),
                new Deck(Arrays.asList(
                        new Card(Rank.Six, Suit.Spades),
                        new Card(Rank.King, Suit.Hearts),
                        new Card(Rank.Nine, Suit.Hearts),
                        new Card(Rank.Ace, Suit.Diamonds),
                        new Card(Rank.Queen, Suit.Spades)
                ))
        );

        HandAndDeckIterator iterator = new HandAndDeckIterator(handAndDeck);
        assertNotNull(iterator);

        HashSet<Hand> iterated = new HashSet<Hand>();
        CollectionUtils.addAll(iterated, iterator);

        assertEquals(iterated.size(), 32);

        assertContainsHand(iterated, //00000
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00001
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00010
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00011
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00100
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Six, Suit.Spades,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00101
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00110
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //00111
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01000
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Six, Suit.Spades,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01001
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.King, Suit.Hearts,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01010
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.King, Suit.Hearts,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01011
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Two, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01100
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01101
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01110
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //01111
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ace, Suit.Diamonds,
                Rank.Ten, Suit.Diamonds);
        assertContainsHand(iterated, //10000
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Six, Suit.Spades);
        assertContainsHand(iterated, //10001
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.King, Suit.Hearts);
        assertContainsHand(iterated, //10010
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.King, Suit.Hearts);
        assertContainsHand(iterated, //10011
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Two, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Nine, Suit.Hearts);
        assertContainsHand(iterated, //10100
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Six, Suit.Spades,
                Rank.Queen, Suit.Diamonds,
                Rank.King, Suit.Hearts);
        assertContainsHand(iterated, //10101
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Nine, Suit.Hearts);
        assertContainsHand(iterated, //10110
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Nine, Suit.Hearts);
        assertContainsHand(iterated, //10111
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Queen, Suit.Diamonds,
                Rank.Ace, Suit.Diamonds);
        assertContainsHand(iterated, //11000
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts);
        assertContainsHand(iterated, //11001
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts);
        assertContainsHand(iterated, //11010
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.Two, Suit.Hearts,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts);
        assertContainsHand(iterated, //11011
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Two, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ace, Suit.Diamonds);
        assertContainsHand(iterated, //11100
                Rank.Three, Suit.Diamonds,
                Rank.Five, Suit.Spades,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts);
        assertContainsHand(iterated, //11101
                Rank.Six, Suit.Spades,
                Rank.Five, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ace, Suit.Diamonds);
        assertContainsHand(iterated, //11110
                Rank.Three, Suit.Diamonds,
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ace, Suit.Diamonds);
        assertContainsHand(iterated, //11111
                Rank.Six, Suit.Spades,
                Rank.King, Suit.Hearts,
                Rank.Nine, Suit.Hearts,
                Rank.Ace, Suit.Diamonds,
                Rank.Queen, Suit.Spades);
    }

    private void assertContainsHand(HashSet<Hand> iterated, Rank rank1, Suit suit1, Rank rank2, Suit suit2,
                                    Rank rank3, Suit suit3, Rank rank4, Suit suit4, Rank rank5, Suit suit5) {
        assertTrue(iterated.contains(new Hand(Arrays.asList(
                new Card(rank1, suit1),
                new Card(rank2, suit2),
                new Card(rank3, suit3),
                new Card(rank4, suit4),
                new Card(rank5, suit5)
        ))));
    }
}
