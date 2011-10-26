package ua.pogodin.poker.card;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergii Pogodin
 */
public class CardTest {

    @DataProvider
    public Object[][] valid() {
        return new Object[][] {
                {"5H", Rank.Five, Suit.Hearts},
                {"QH", Rank.Queen, Suit.Hearts},
                {"6S", Rank.Six, Suit.Spades},
                {"TC", Rank.Ten, Suit.Clubs},
                {"2H", Rank.Two, Suit.Hearts},
                {"KS", Rank.King, Suit.Spades},
                {"3D", Rank.Three, Suit.Diamonds},
                {"AH", Rank.Ace, Suit.Hearts},
                {"9C", Rank.Nine, Suit.Clubs},
                {"JD", Rank.Jack, Suit.Diamonds}
        };
    }

    @Test(dataProvider = "valid")
    public void cardShouldBeParsedCorrectly(String abbreviation, Rank expectedRank, Suit expectedSuit) {
        assertEquals(Card.parse(abbreviation), new Card(expectedRank, expectedSuit));
    }

    @DataProvider
    public Object[][] invalid() {
        return new Object[][] {
                {"d"}, {""}, {"QH "}, {"QW"}, {"5T"}, {null}
        };
    }

    @Test(dataProvider = "invalid", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionOnIncorrectIncomeString(String incorrectAbbreviation) throws Exception {
        Card.parse(incorrectAbbreviation);
    }
}
