package ua.pogodin.poker.pockerhand.definer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.pogodin.poker.card.Card;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static ua.pogodin.poker.card.Rank.Ace;
import static ua.pogodin.poker.card.Rank.Five;
import static ua.pogodin.poker.card.Rank.Four;
import static ua.pogodin.poker.card.Rank.Jack;
import static ua.pogodin.poker.card.Rank.King;
import static ua.pogodin.poker.card.Rank.Nine;
import static ua.pogodin.poker.card.Rank.Queen;
import static ua.pogodin.poker.card.Suit.Clubs;
import static ua.pogodin.poker.card.Suit.Diamonds;
import static ua.pogodin.poker.card.Suit.Hearts;
import static ua.pogodin.poker.card.Suit.Spades;

/**
 * @author Sergii Pogodin
 */
public class DefinerUtilsTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {Arrays.asList(
                        new Card(Ace, Diamonds),
                        new Card(Ace, Clubs),
                        new Card(Ace, Hearts),
                        new Card(Four, Clubs),
                        new Card(Ace, Spades)), new Integer[]{4, 1}},
                {Arrays.asList(
                        new Card(Five, Diamonds),
                        new Card(King, Diamonds),
                        new Card(Ace, Hearts),
                        new Card(Four, Clubs),
                        new Card(Jack, Spades)), new Integer[]{1, 1, 1, 1, 1}},
                {Arrays.asList(
                        new Card(Nine, Hearts),
                        new Card(Queen, Clubs),
                        new Card(Ace, Clubs),
                        new Card(Nine, Diamonds),
                        new Card(Queen, Clubs)), new Integer[]{2, 2, 1}},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void cardsWithSameRankShouldBeCalculatedProperly(List<Card> cards, Integer[] expectedCountsArray) {
        assertEquals(DefinerUtils.calcSameRankCardsQuantities(cards), expectedCountsArray);
    }
}
