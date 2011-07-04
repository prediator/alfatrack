package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TextBuilderTest {
	private TextBuilder builder;
	
	@Before
	public void setUp() {
		builder = new TextBuilder();
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
		
		assertEquals("Sparta have party way go is is is no over the This to you When", result);
	}
}
