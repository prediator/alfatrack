package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.pogodin.wp.items.Mark;
import com.pogodin.wp.items.SentencePart;
import com.pogodin.wp.items.Space;
import com.pogodin.wp.items.Word;


public class SentencePartTest {
	
	private SentencePart sentencePart;
	
	@Test
	public void WordToStringTest(){
		sentencePart = new Word("hello");
		String result = sentencePart.toSting();
		
		assertEquals("hello", result);
	}
	
	@Test
	public void SpaceToStringInSentencePartTest(){
		sentencePart = new Space();
		String result = sentencePart.toSting();
		
		assertEquals(" ", result);
	}
	
	@Test
	public void MarkToStringInSentencePartTest(){
		sentencePart = new Mark(';');
		String result = sentencePart.toSting();
		
		assertEquals(";", result);
	}
}
