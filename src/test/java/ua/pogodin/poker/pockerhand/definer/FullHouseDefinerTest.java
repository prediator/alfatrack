package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class FullHouseDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][]{
                {"AS 4D AC AD 4H", true},
                {"5S QH QS 5D QC", true},
                {"3C 2C 2D 2H 2S", false},
                {"AS 4D AC KD 4H", false},
        };
    }

    @Override
    protected PokerHandDefiner createDefiner() {
        return new FullHouseDefiner();
    }
}
