package com.pogodin.wp.items;

public class Mark extends Symbol implements SentencePart {
	public Mark(char input) {
		super(input);
	}

	@Override
	public boolean isWord() {
		return false;
	}
}
