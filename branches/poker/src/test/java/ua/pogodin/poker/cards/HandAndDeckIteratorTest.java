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
    }
}
