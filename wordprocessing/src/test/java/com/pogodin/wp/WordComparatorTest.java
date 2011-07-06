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
		
		List<Word> testingWords = new ArrayList<Word>();
		testingWords.add(new Word("apple"));
		testingWords.add(new Word("aaas"));
		testingWords.add(new Word("apla"));
		testingWords.add(new Word("apply"));
		
		WordComparator compar = new WordComparator(new Letter('a'));
		Collections.sort(testingWords, compar);

		List<Word> expected = new ArrayList<Word>();
		expected.add(new Word("apply"));
		expected.add(new Word("apple"));
		expected.add(new Word("apla"));
		expected.add(new Word("aaas"));
		
		assertEquals(testingWords, expected);
		
	}
	
}
