package ua.pogodin.poker;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Sergii Pogodin
 */
public class FileFacadeTest {
    @Test
    public void shouldConvertInputFileWithHandAndDeckToOutputFileWithPokerHandDetermined() throws Exception {
        new FileFacade().processTheFile("./src/test/resources/test_input.txt");

        File resultFile = new File("./src/test/resources/test_input_result.txt");
        assertTrue(resultFile.exists());

        FileReader resultFileReader = new FileReader(resultFile);
        String result = IOUtils.toString(resultFileReader);

        FileReader expectedResultFileReader = new FileReader("./src/test/resources/test_expected_output.txt");
        String expectedResult = IOUtils.toString(expectedResultFileReader);

        assertEquals(result, expectedResult);

        IOUtils.closeQuietly(resultFileReader);
        IOUtils.closeQuietly(expectedResultFileReader);
        resultFile.deleteOnExit();
    }
}
