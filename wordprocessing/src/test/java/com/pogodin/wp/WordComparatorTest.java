package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Word;


public class WordComparatorTest {
	
	
	@Test
	public void wordsShouldSortedByLetter(){
		
		String s1 = "this";
		String s2 = "to";
		String s3 = "when";
		String s4 = "you";
		
		
		List<Word> testingWords = new ArrayList<Word>();
		testingWords.add(new Word(s1));
		testingWords.add(new Word(s3));
		testingWords.add(new Word(s4));
		testingWords.add(new Word(s2));
		
		WordConverter compar = new WordConverter(new Letter('a'));
		Collections.sort(testingWords, compar);

		List<Word> expected = new ArrayList<Word>();
		expected.add(new Word(s1));
		expected.add(new Word(s2));
		expected.add(new Word(s3));
		expected.add(new Word(s4));
		
		//TODO replace to assertArraysEqual
		assertEquals(expected.toString(), testingWords.toString());
		
	}
	
}
