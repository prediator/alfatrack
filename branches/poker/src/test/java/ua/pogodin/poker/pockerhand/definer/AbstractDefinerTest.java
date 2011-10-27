package ua.pogodin.poker.pockerhand.definer;

import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.pogodin.poker.cards.Hand;

/**
 * @author Sergii Pogodin
 */
public abstract class AbstractDefinerTest {
    private PokerHandDefiner definer;

    @BeforeClass
    public void init() {
        definer = createDefiner();
    }

    @DataProvider
    public Object[][] dataProvider() {
        return getDataProvider();
    }

    @Test(dataProvider = "dataProvider")
    public void testDefine(String string, boolean isDefined) throws Exception {
        Assert.assertTrue(definer.define(Hand.parse(string)) == isDefined);
    }
    
    protected abstract Object[][] getDataProvider();

    protected abstract PokerHandDefiner createDefiner();
}
