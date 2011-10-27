package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class StraightFlushDefinerTest extends AbstractDefinerTest {

    @Override
    protected Object[][] getDataProvider() {
        return new Object[][] {
                {"AH QH TH JH KH", true},
                {"AC 5C 4C 3C 2C", true},
                {"6S 3S 4S 5S 2S", true},
                {"8H 9H TH JH 7H", true},
                {"AC 6C 5C 4C 3C", false},
                {"AD KD QD JC TD", false}
        };
    }

    @Override
    protected PokerHandDefiner createDefiner() {
        return new StraightFlushDefiner();
    }
}
