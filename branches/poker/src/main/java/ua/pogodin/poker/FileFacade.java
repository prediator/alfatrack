package ua.pogodin.poker;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import ua.pogodin.poker.cards.HandAndDeck;
import ua.pogodin.poker.pockerhand.PokerHand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Sergii Pogodin
 */
public class FileFacade {
    public static final String OUTPUT_STRING_TEMPLATE = "%s Best hand: %s";

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Please specify the input file as argument");
        }
        new FileFacade().processTheFile(args[0]);
    }

    void processTheFile(String inputFilePath) throws IOException {
        Reader reader = createReader(inputFilePath);

        BufferedWriter writer = createWriter(inputFilePath);

        HandDefinerFacade handDefinerFacade = new HandDefinerFacade();

        for (String line : IOUtils.readLines(reader)) {
            if (StringUtils.isNotBlank(line)) {
                HandAndDeck handAndDeck = HandAndDeck.parse(line.trim());
                PokerHand pokerHand = handDefinerFacade.define(handAndDeck);

                writer.write(String.format(OUTPUT_STRING_TEMPLATE, handAndDeck, pokerHand));
                writer.newLine();
            }
        }

        IOUtils.closeQuietly(reader);
        IOUtils.closeQuietly(writer);
        System.out.println("Done");
    }

    private Reader createReader(String inputFilePath) throws FileNotFoundException {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            System.out.println(String.format("File \"%s\" is not exist", inputFile.getAbsoluteFile()));
        }
        System.out.println("Reading file " + inputFile.getAbsolutePath());
        return new FileReader(inputFile);
    }

    private BufferedWriter createWriter(String inputFilePath) throws IOException {
        String resultFilePath = getResultFilePath(inputFilePath);
        File resultFile = createResultFile(resultFilePath);
        return new BufferedWriter(new FileWriter(resultFile));
    }

    private String getResultFilePath(String inputFilePath) {
        int dotPosition = inputFilePath.lastIndexOf(".");
        return inputFilePath.substring(0, dotPosition) + "_result." + inputFilePath.substring(dotPosition + 1);
    }

    private File createResultFile(String resultFilePath) throws IOException {
        File resultFile = new File(resultFilePath);
        if (resultFile.exists()) {
            boolean deleted = resultFile.delete();
            if (!deleted) {
                throw new IOException(String.format("Can't delete old result file %s", resultFilePath));
            }
        }
        boolean created = resultFile.createNewFile();
        if (!created) {
            throw new IOException(String.format("Can't create result file %s", resultFilePath));
        }
        System.out.println("Writing to file " + resultFile.getAbsolutePath());
        return resultFile;
    }
}
