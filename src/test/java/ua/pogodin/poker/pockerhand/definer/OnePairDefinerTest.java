package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class OnePairDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][] {
                {"KH QD 4C KS 8S", true},
                {"9H JS TS 9C 9D", true},
                {"7C 6C 5S QC TC", false},
                {"8C 3C AS 3D AC", false}
        };
    }

    @Override
    protected PokerHandDefiner createDefiner() {
        return new OnePairDefiner();
    }
}
