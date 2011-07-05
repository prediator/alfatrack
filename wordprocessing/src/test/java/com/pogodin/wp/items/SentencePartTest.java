package com.pogodin.wp.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pogodin.wp.items.Mark;
import com.pogodin.wp.items.SentencePart;
import com.pogodin.wp.items.Space;
import com.pogodin.wp.items.Word;

public class SentencePartTest {

	@Test
	public void wordToStringShouldGenerateContent() {
		SentencePart sentencePart = new Word("hello");
		String result = sentencePart.toString();

		assertEquals("hello", result);
	}

	@Test
	public void spaceToStringShouldGenerateASpace() {
		SentencePart sentencePart = new Space();
		String result = sentencePart.toString();

		assertEquals(" ", result);
	}

	@Test
	public void markToStringShouldGenerateMarkSign() {
		SentencePart sentencePart = new Mark(';');
		String result = sentencePart.toString();

		assertEquals(";", result);
	}
}
