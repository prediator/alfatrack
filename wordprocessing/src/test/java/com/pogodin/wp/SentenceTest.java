package com.pogodin.wp;

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
	public void setUp(){
		sentence = new Sentence();
	}
	
	@Test
	public void sentenceToStringTest(){
		
		String initialText = "this is sparta!";
		sentence.setSentence(initialText);
		String result = sentence.toString();
		
		assertEquals(initialText, result);
		
	}
	
	@Test
	public void sentenceGetIndexTest(){
		
		String initialText = "this is sparta!";
		sentence.setSentence(initialText);
		Word expected = new Word ("this");
		
		assertEquals(expected.toSting(), sentence.get(0).toSting());
		
	}
	@Test
	public void regexTest(){
		
		String initialText = "hello  \t  how  are u?";
		initialText = initialText.replaceAll("[\\r,\\n,\\t, ]+", " ");
		String expected = "hello how are u?";
		
		assertEquals(expected, initialText);
	}
}
