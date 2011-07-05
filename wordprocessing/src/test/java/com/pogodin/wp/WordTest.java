package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.SentencePart;
import com.pogodin.wp.items.Word;

public class WordTest {

	private Word word;
	private SentencePart part;
	
	@Before
	public void setUp(){
		word = new Word();
	}
	
	@Test
	public void wordToStringListOfLettersTest(){
		Letter one = new Letter('a');
		Letter two = new Letter('b');
		Letter three = new Letter('c');
		Letter four = new Letter('z');
		ArrayList<Letter> letters = new ArrayList<Letter>();
		letters.add(one);
		letters.add(two);
		letters.add(three);
		letters.add(four);
		
		word.setLetters(letters);
		String result = word.toSting();
		
		assertEquals("abcz", result);
	}
	
	@Test
	public void wordToStringFromSubstringTest(){
		String initialText = "howdoyoulike";
		//d == 3; l == 8
		word.setLetters(initialText, 3, 8);
		String result = word.toSting();
		
		assertEquals("doyou", result);
	}
	
	
}
