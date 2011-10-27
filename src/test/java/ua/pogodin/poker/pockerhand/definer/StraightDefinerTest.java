package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class StraightDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][] {
                {"AH QH TH JH KH", true},
                {"JC 7D 9S 8D TH", true},
                {"3H 4S AS 5C 2C", true},
                {"7C 6C 5S QC TC", false}
        };
    }

    @Override
    protected PokerHandDefiner createDefiner() {
        return new StraightDefiner();
    }
}
