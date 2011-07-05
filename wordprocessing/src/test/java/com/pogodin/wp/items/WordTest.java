package com.pogodin.wp.items;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Word;

public class WordTest {

	private Word word;

	@Before
	public void setUp() {
		word = new Word();
	}

	@Test
	public void wordToStringShouldOutputListOfLetters() {
		word.setLetters(Arrays.asList(
				new Letter('a'), new Letter('b'),
				new Letter('c'), new Letter('z')));
		
		String result = word.toString();

		assertEquals("abcz", result);
	}

	@Test
	public void wordToStringFromSubstring() {
		String initialText = "howdoyoulike";
		// d == 3; l == 8
		word.setLetters(initialText, 3, 8);
		
		String result = word.toString();

		assertEquals("doyou", result);
	}
}
