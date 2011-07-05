package com.pogodin.wp.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Mark;
import com.pogodin.wp.items.Space;
import com.pogodin.wp.items.Symbol;

public class SymbolTest {

	private Symbol symbol;

	@Test
	public void toStringLowerCaseTest() {
		symbol = new Letter('v');
		String result = symbol.toString();
		assertEquals("v", result);
	}

	@Test
	public void toStringUpperCaseTest() {
		symbol = new Letter('V');
		String result = symbol.toString();
		assertEquals("V", result);
	}

	@Test
	public void toStringSpaceTest() {
		symbol = new Space();
		String result = symbol.toString();
		assertEquals(" ", result);
	}

	@Test
	public void toStringMarkTest() {
		symbol = new Mark(';');
		String result = symbol.toString();
		assertEquals(";", result);
	}

}
