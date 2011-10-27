package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class TwoPairDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][] {
                {"7H 7D JC 5H JS", true},
                {"7H 7D JC 5H JS", true},
                {"7C 6C 5S QC TC", false},
                {"4C 6C KS 4H AD", false}
        };
    }

    @Override
    protected PokerHandDefiner getDefiner() {
        return new TwoPairDefiner();
    }
}
