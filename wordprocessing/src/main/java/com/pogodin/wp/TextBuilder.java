package com.pogodin.wp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Sentence;
import com.pogodin.wp.items.Word;

public class TextBuilder {
	private String text;
	private Character symbol;
	
	public void setText(String text) {
		this.text = text;
	}

	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	public String convertToSortedWords() {
		if (symbol == null || "".equals(text)) {
			return text;
			
		}
		SentenceParser parser = SentenceParser.getInstance();
		List<Word> wordPack = new ArrayList<Word>();
		WordComparator wc = new WordComparator(new Letter('a'));
		String result = "";

		for(Sentence cur : parser.parseSentences(text)){
			wordPack.addAll(cur.getWords());
		}
		
		
		Collections.sort(wordPack, wc);
		for (Word iterWord : wordPack) {
			result += iterWord.toString() + " ";
		}
		
		return result;
	}
}
