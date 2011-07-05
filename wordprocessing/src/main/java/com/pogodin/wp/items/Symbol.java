package com.pogodin.wp.items;

public abstract class Symbol implements Comparable<Symbol> {
	private char symbol;

	public Symbol(char input) {
		symbol = input;
	}

	public char getSymbol() {
		return symbol;
	}

	@Override
	public int compareTo(Symbol o) {
		char first = Character.toLowerCase(getSymbol());
		char second = Character.toLowerCase(o.getSymbol());

		return second - first;
	}

	@Override
	public int hashCode() {
		return symbol;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Symbol)) {
			return false;
		}

		Symbol other = (Symbol) obj;

		return symbol == other.symbol;
	}

	public String toString() {
		return String.valueOf(symbol);
	}
}
