package com.pogodin.wp;

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
		
		return null;
	}
}
