package ua.pogodin.poker.pockerhand.definer;

/**
 * @author Sergii Pogodin
 */
public class FourOfKindDefinerTest extends AbstractDefinerTest {
    @Override
    protected Object[][] getDataProvider() {
        return new Object[][]{
                {"AS 4D AC AD AH", true},
                {"5S 5H QH 5D 5C", true},
                {"3C 2C 2D 2H 2S", true},
                {"AS 4D AC AD 4H", false},
        };
    }

    @Override
    protected PokerHandDefiner createDefiner() {
        return new FourOfKindDefiner();
    }
}
