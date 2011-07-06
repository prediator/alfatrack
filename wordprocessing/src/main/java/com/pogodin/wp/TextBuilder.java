package com.pogodin.wp;

import java.util.ArrayList;
import java.util.List;

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

		for(Sentence cur : parser.parseSentences(text)){
			wordPack.addAll(cur.getWords());
		}
		
		
		return null;
	}
}
