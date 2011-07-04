package com.pogodin.wp.items;

public abstract class Symbol {
	private char symbol;

	public Symbol(char input) {
		symbol = input;
	}

	public char getSymbol() {
		return symbol;
	}

	public String toString() {
		return String.valueOf(symbol);
	}
}
