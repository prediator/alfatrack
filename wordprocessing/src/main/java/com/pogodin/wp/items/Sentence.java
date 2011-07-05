package com.pogodin.wp.items;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

	private List<SentencePart> parts = new ArrayList<SentencePart>();
	private List<Integer> wordIndices = new ArrayList<Integer>(); 

	public Sentence() {
	}

	public void setSentence(String input) {
		input = replaceWhitespaceCharactersBySpace(input);

		List<Letter> curWord = new ArrayList<Letter>();
		
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (Character.isLetter(cur)) {
				curWord.add(new Letter(cur));
			} else {
				createNewWord(curWord);

				if (Character.isSpaceChar(cur)) {
					parts.add(new Space());
				} else {
					parts.add(new Mark(cur));
				}
			}
		}
		
		if (!curWord.isEmpty()) {
			parts.add(new Word(curWord));
		}
	}

	private void createNewWord(List<Letter> curWord) {
		wordIndices.add(parts.size());
		parts.add(new Word(curWord));
		curWord = new ArrayList<Letter>();
	}

	String replaceWhitespaceCharactersBySpace(String input) {
		return input.replaceAll("\\s+", " ");
	}

	public SentencePart get(int index) {
		return parts.get(index);
	}

	@Override
	public String toString() {
		String result = "";

		for (SentencePart part : parts) {
			result += part.toString();
		}
		return result;
	}
}
