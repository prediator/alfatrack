package ua.pogodin.poker.card;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.pogodin.poker.card.Card;
import ua.pogodin.poker.card.Kind;
import ua.pogodin.poker.card.Suit;

public class CardTest {

    @DataProvider
    public Object[][] valid() {
        return new Object[][] {
                {"5H", Kind.Five, Suit.Hearts},
                {"QH", Kind.Queen, Suit.Hearts},
                {"6S", Kind.Six, Suit.Spades},
                {"TC", Kind.Ten, Suit.Clubs},
                {"2H", Kind.Two, Suit.Hearts},
                {"KS", Kind.King, Suit.Spades},
                {"3D", Kind.Three, Suit.Diamonds},
                {"AH", Kind.Ace, Suit.Hearts},
                {"9C", Kind.Nine, Suit.Clubs},
                {"JD", Kind.Jack, Suit.Diamonds}
        };
    }

    @Test(dataProvider = "valid")
    public void cardShouldBeParsedCorrectly(String abbreviation, Kind expectedKind, Suit expectedSuit) {
        assertEquals(Card.parse(abbreviation), new Card(expectedKind, expectedSuit));
    }

    @DataProvider
    public Object[][] invalid() {
        return new Object[][] {
                {"d"}, {""}, {"QH "}, {"QW"}, {"5T"}, {null}
        };
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionOnIncorrectIncomeString(String incorrectAbbreviation) throws Exception {
        Card.parse(incorrectAbbreviation);
    }
}
