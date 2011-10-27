package ua.pogodin.poker.cards;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Rank;
import ua.pogodin.poker.card.Suit;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergii Pogodin
 */
public class HandAndDeckTest {
    @Test
    public void shouldBeParsedWithoutException() throws Exception {
        String abbreviation = "TH JH QC QD QS QH KH AH 2S 6S";
        HandAndDeck.parse(abbreviation);
    }

    @DataProvider
    public Object[][] invalid() {
        return new Object[][]{
                {"2H 2S 3H 3S 3C 2D 3D 6C 9C TH "},
                {"2H2S 3H 3S 3C 2D 3D 6C 9C TH "},
                {"6CF9C 8C 2D 7C 2H TC 4C 9S AH"},
                {null}
        };
    }

    @Test(dataProvider = "invalid", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionOnIncorrectIncomeString(String incorrectAbbreviation) throws Exception {
        HandAndDeck.parse(incorrectAbbreviation);
    }

    @Test
    public void toStringShouldReturnAbbreviations() throws Exception {
        HandAndDeck handAndDeck = new HandAndDeck(
                new Hand(Arrays.asList(
                        new Card(Rank.King, Suit.Clubs),
                        new Card(Rank.Four, Suit.Hearts),
                        new Card(Rank.Eight, Suit.Spades),
                        new Card(Rank.Seven, Suit.Clubs),
                        new Card(Rank.Ace, Suit.Diamonds)
                )),
                new Deck(Arrays.asList(
                        new Card(Rank.Ten, Suit.Spades),
                        new Card(Rank.Ace, Suit.Diamonds),
                        new Card(Rank.Nine, Suit.Hearts),
                        new Card(Rank.Five, Suit.Diamonds),
                        new Card(Rank.Queen, Suit.Clubs)
                )));
        assertEquals(handAndDeck.toString(), "Hand: AD KC 8S 7C 4H Deck: TS AD 9H 5D QC");
    }
}
