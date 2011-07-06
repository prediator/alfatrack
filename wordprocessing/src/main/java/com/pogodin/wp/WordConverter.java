package com.pogodin.wp;

import java.util.Comparator;
import java.util.List;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Word;

public class WordConverter implements Comparator<Word> {
	private Letter usingLetter;

	public WordConverter(Letter a) {
		usingLetter = a;
	}

	public WordConverter() {

	}

	@Override
	public int compare(Word first, Word other) {
		if (first.equals(other)) {
			return 0;
		}
		if (first.countLettersInWord(usingLetter) != other.countLettersInWord(usingLetter))
			// todo remove round braces+
			return other.countLettersInWord(usingLetter) - first.countLettersInWord(usingLetter);

		else {
			// TODO use Math.min
			int minLen = first.length() < other.length() ? first.length() : other.length();

			// TODO remove all the following and replace by
			// first.toString().compareTo(second.toString())
			List<Letter> firstLetters = first.getLetters();
			List<Letter> otherLetters = other.getLetters();

			for (int i = 0; i < minLen; i++) {
				int current = firstLetters.get(i).compareTo(otherLetters.get(i));
				if (current != 0) {
					return -current;
				}
			}
			if (minLen < first.length()) {
				return 1;
			}
			return -1;
		}
	}
}
