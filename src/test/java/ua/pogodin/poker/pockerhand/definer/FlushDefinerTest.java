package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class FlushDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][] {
                {"AH QH TH JH KH", true},
                {"JS 3S KS 5S 9S", true},
                {"7C 6C 5S QC TC", false}
        };
    }

    @Override
    protected PokerHandDefiner getDefiner() {
        return new FlushDefiner();
    }
}
