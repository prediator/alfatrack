package ua.pogodin.poker.pockerhand.definer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Sergii Pogodin
 */
public abstract class AbtractDefinerTest {
    @DataProvider
    public Object[][] dataProvider() {
        return getData();
    }

    protected abstract Object[][] getData();

    @Test(dataProvider = "dataProvider")
    public void testDefine() throws Exception {

    }
}
