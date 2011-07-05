package com.pogodin.wp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pogodin.wp.items.Sentence;

public class SentenceParcerTest {

	private SentenceParser parser;

	@Before
	public void setUp() {
		parser = SentenceParser.getInstance();
	}
	
	@Test
	public void shouldParseSingleWord() {
		String text = "theword";
		
		List<Sentence> sentences = parser.parseSentences(text);

		assertNotNull(sentences);
		assertEquals(1, sentences.size());
		assertEquals(1, sentences.get(0).partsCount());
		assertEquals("theword", sentences.get(0).get(0).toString());
		
		//TODO add getWords check
	}
	
	@Test
	public void shouldParseSingleSentence() {
		String text = "This is sparta!";
		
		List<Sentence> sentences = parser.parseSentences(text);

		assertNotNull(sentences);
		assertEquals(1, sentences.size());
		
		assertEquals(6, sentences.get(0).partsCount());
		assertEquals("This", sentences.get(0).get(0).toString());
		assertEquals(" ", sentences.get(0).get(1).toString());
		assertEquals("is", sentences.get(0).get(2).toString());
		assertEquals(" ", sentences.get(0).get(3).toString());
		assertEquals("sparta", sentences.get(0).get(4).toString());
		assertEquals("!", sentences.get(0).get(5).toString());
		
		//TODO add getWords check
	}

	@Test
	public void shouldParseMulipleSentences() {
		String text = "Madness? This is sparta!";
		
		List<Sentence> sentences = parser.parseSentences(text);

		assertNotNull(sentences);
		assertEquals(2, sentences.size());
		
		assertEquals(2, sentences.get(0).partsCount());
		assertEquals("Madness", sentences.get(0).get(0).toString());
		assertEquals("?", sentences.get(0).get(1).toString());
		
		assertEquals(7, sentences.get(1).partsCount());
		assertEquals(" ", sentences.get(1).get(0).toString());
		assertEquals("This", sentences.get(1).get(1).toString());
		assertEquals(" ", sentences.get(1).get(2).toString());
		assertEquals("is", sentences.get(1).get(3).toString());
		assertEquals(" ", sentences.get(1).get(4).toString());
		assertEquals("sparta", sentences.get(1).get(5).toString());
		assertEquals("!", sentences.get(1).get(6).toString());
		
		//TODO add getWords check
	}
}
