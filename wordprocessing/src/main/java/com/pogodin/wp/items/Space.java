package com.pogodin.wp.items;

public class Space extends Symbol implements SentencePart {
	public Space() {
		super(' ');
	}

	@Override
	public boolean isWord() {
		return false;
	}
}
