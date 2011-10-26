package ua.pogodin.poker.cards;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        return new Object[][] {
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
}
