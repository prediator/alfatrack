package com.pogodin.wp;

import java.util.ArrayList;
import java.util.List;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Mark;
import com.pogodin.wp.items.Sentence;
import com.pogodin.wp.items.Space;
import com.pogodin.wp.items.Word;

/**
 * Singleton which parses a text representation to List of Sentences
 * 
 * @author elias
 */
public class SentenceParser {
	private static final String END_SENTENCE_SIGNS = ".?!";
	
	private static SentenceParser instance = new SentenceParser();

	private SentenceParser() {
	};

	public static SentenceParser getInstance() {
		return instance;
	}

	private enum PartType {
		WORD, SPACE
	}

	public List<Sentence> parseSentences(String text) {
		List<Sentence> sentences = new ArrayList<Sentence>();
		Sentence sentence = new Sentence();
		List<Letter> curWord = new ArrayList<Letter>();
		PartType lastPart = null;

		for (int i = 0; i < text.length(); i++) {
			char cur = text.charAt(i);
			if (Character.isLetterOrDigit(cur)) {
				curWord.add(new Letter(cur));
				
				lastPart = PartType.WORD;
			} else if (Character.isSpaceChar(cur)) {
				if (lastPart != PartType.SPACE) {
					addWordIfNeeded(sentence, curWord, lastPart);
					sentence.addSentencePart(new Space());
				}
				
				lastPart = PartType.SPACE;
			} else {
				addWordIfNeeded(sentence, curWord, lastPart);
				sentence.addSentencePart(new Mark(cur));
				addSentenceIfNeeded(sentences, sentence, cur);
				
				lastPart = null;
			}
		}

		addWordIfNeeded(sentence, curWord, lastPart);
		if (lastPart != null) {
			sentences.add(sentence);
		}
		
		return sentences;
	}

	private void addSentenceIfNeeded(List<Sentence> sentences, Sentence sentence, char cur) {
		if (END_SENTENCE_SIGNS.contains(String.valueOf(cur))) {
			sentences.add(new Sentence(sentence));
			sentence.clear();
		}
	}

	private void addWordIfNeeded(Sentence sentence, List<Letter> curWord, PartType lastPart) {
		if (lastPart == PartType.WORD) {
			createNewWord(sentence, curWord);
		}
	}

	private void createNewWord(Sentence sentence, List<Letter> curWord) {
		sentence.addSentencePart(new Word(new ArrayList<Letter>(curWord)));
		curWord.clear();
	}

}
