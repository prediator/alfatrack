package com.pogodin.wp.items;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart {
	private List<Letter> letters = new ArrayList<Letter>();;

	public Word(List<Letter> input) {
		letters = input;
	}

	public Word(String text, int begin, int end) {
		char[] chars = text.substring(begin, end).toCharArray(); //TODO move substring to invoker
		
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

	public boolean equals(Word input) {
		if (input.length() != letters.size()) {
			return false;
		}
		
		for (int i = 0; i < letters.size(); i++) {
			if (input.getLetters().get(i).equals(letters.get(i))) {
				return false;
			}
		}
		return true;
	}

	public int countLetterInputTimes(Letter letter) {
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

	public String toSting() {
		String res = "";

		for (Letter s : letters) {
			res += s.toString();
		}

		return res;
	}
}