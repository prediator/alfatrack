package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TextConverterTest {
	private TextConverter builder;
	
	@Before
	public void setUp() {
		builder = new TextConverter();
	}

	@Test
	public void emptyTextShouldBeConvertedToEmptyText() {
		builder.setText("");
		String result = builder.convertToSortedWords();
		
		assertEquals("", result);
	}
	
	@Test
	public void shouldReturnInitialTextWhenSymbolIsNull() {
		String initialText = "This is Sparta. Then the party is over you have no way to go.";
		builder.setText(initialText);
		String result = builder.convertToSortedWords();
		
		assertEquals(initialText, result);
	}
	
	@Test
	public void shouldReturnSortedWordsOnSunnyDayScenario() {
		String initialText = "This is Sparta.\r\n\t When the party is over you have no way to go.";
		builder.setText(initialText);
		builder.setSymbol('a');
		String result = builder.convertToSortedWords();
		
		assertEquals("Sparta have party way go is is no over the This to When you ", result);
	}
	@Test
	public void shouldGetTextFromFileAndConvertItToAnotherOne(){
		
		String input = "inp.txt";
		String output = "out.txt";
		String fileContent = "some text will be here. Ok? byebye";
		String expected = "byebye be here Ok some text will ";
		
		FileReaderWriter.writeFile(fileContent, input);
		
		TextConverter tc = new TextConverter();
		tc.readWriteConvert(input, output, 'b');
		
		assertEquals(expected, FileReaderWriter.readFile(output));
	}
}
