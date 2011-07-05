package com.pogodin.wp.items;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart {
	private List<Letter> letters = new ArrayList<Letter>();;

	public Word(List<Letter> input) {
		letters = input;
	}

	public Word() {
	}

	public Word(String text, int begin, int end) {
		setLetters(text, begin, end);
	}

	public Word(String text) {
		setLetters(text, 0, text.length());
	}

	public void setLetters(String text, int begin, int end) {
		if (end > text.length()) {
			end = text.length();
		}

		// TODO move substring to invoker
		char[] chars = text.substring(begin, end).toCharArray();

		for (char c : chars) {
			letters.add(new Letter(c));
		}
	}

	public List<Letter> getLetters() {
		return letters;
	}

	public void setLetters(List<Letter> letters) {
		this.letters = letters;
	}

	public int length() {
		return letters.size();
	}

	public int countLettersInWord(Letter letter) {
		int value = 0;

		for (Letter l : letters) {
			if (l.equals(letter))
				value++;
		}

		return value;
	}

	public Letter get(int i) {
		return letters.get(i);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Word)) {
			return false;
		}
		
		Word other = (Word) obj;
		return letters == null ? other.letters == null : letters.equals(other.letters);
	}
	
	@Override
	public int hashCode() {
		return letters == null ? 0 : letters.hashCode();
	}
	
	@Override
	public String toString() {
		String res = "";

		for (Letter s : letters) {
			res += s.toString();
		}

		return res;
	}
}