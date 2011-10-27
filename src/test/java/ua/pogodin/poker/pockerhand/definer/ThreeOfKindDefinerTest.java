package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class ThreeOfKindDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][] {
                {"AH AD AC 4H JS", true},
                {"3H 4S 3S 3C KC", true},
                {"7C 6C 5S QC TC", false},
                {"4C 6C 4S 4H 4D", false}
        };
    }

    @Override
    protected PokerHandDefiner getDefiner() {
        return new ThreeOfKindDefiner();
    }
}
