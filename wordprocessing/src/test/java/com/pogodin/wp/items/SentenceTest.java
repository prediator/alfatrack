package com.pogodin.wp.items;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Sentence;
import com.pogodin.wp.items.Word;

public class SentenceTest {
	private Sentence sentence;

	@Before
	public void setUp() {
		sentence = new Sentence();
	}

	@Test
	public void sentenceToStringShouldGenerateItsContent() {
		String initialText = "this is sparta!";
		sentence.setSentence(initialText);
		String result = sentence.toString();

		assertEquals(initialText, result);
	}

	@Test
	public void get0FromSentenceShouldReturnFirstWord() {
		String initialText = "this is sparta!";
		sentence.setSentence(initialText);
		Word expected = new Word("this");

		assertEquals(expected, sentence.get(0));
	}

	@Test
	public void testReplaceWhitespaceCharactersBySpace() {
		String initialText = "hello  \t  how  are u?";
		
		String result = sentence.replaceWhitespaceCharactersBySpace(initialText);
		assertEquals("hello how are u?", result);
	}
}
