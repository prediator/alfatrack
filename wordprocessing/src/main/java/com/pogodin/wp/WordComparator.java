package com.pogodin.wp;

import java.util.Comparator;
import java.util.List;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Word;

public class WordComparator implements Comparator<Word> {
	@Override
	public int compare(Word first, Word second) {
		if (first.equals(second))
			return 0;
		else {
			int minLen = first.length();
			boolean isSecondLonger = true;
			if (second.length() < minLen) {
				minLen = second.length();
				isSecondLonger = false;
			}
			List<Letter> firstMain = first.getLetters();
			List<Letter> secondMain = second.getLetters();
			int current;

			for (int i = 0; i < minLen; i++) {
				current = firstMain.get(i).compareTo(secondMain.get(i));
				if (current != 0) {
					return current;
				}
			}
			if (isSecondLonger) {
				return 1;
			}
			return -1;
		}
	}
}
