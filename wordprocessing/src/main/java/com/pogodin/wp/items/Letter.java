package com.pogodin.wp.items;

public class Letter extends Symbol implements Comparable<Letter> {

	public Letter(char input) {
		super(input);
	}

	@Override
	public int compareTo(Letter o) {
		char first = Character.toLowerCase(getSymbol());
		char second = Character.toLowerCase(o.getSymbol());

		return second - first;
	}

	public boolean equals(Letter input) {
		return input.getSymbol() == getSymbol();
	}
}
