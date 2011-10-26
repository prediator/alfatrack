package ua.pogodin.poker.pockerhand.definer;

import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.pogodin.poker.cards.Hand;

/**
 * @author Sergii Pogodin
 */
public class StraightFlushDefinerTest {

    private static StraightFlushDefiner straightFlushDefiner;

    @BeforeClass
    public static void init() {
        straightFlushDefiner = new StraightFlushDefiner();
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
                {"AH QH TH JH KH", true},
                {"AC 5C 4C 3C 2C", true},
                {"6S 3S 4S 5S 2S", true},
                {"8H 9H TH JH 7H", true},
                {"AC 6C 5C 4C 3C", false},
                {"AD KD QD JC TD", false}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testDefine(String string, boolean isDefined) throws Exception {
        Assert.assertTrue(straightFlushDefiner.define(Hand.parse(string)) == isDefined);
    }
}
