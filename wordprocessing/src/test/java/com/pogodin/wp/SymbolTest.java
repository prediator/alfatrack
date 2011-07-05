package com.pogodin.wp;

import static org.junit.Assert.assertEquals;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Mark;
import com.pogodin.wp.items.Space;
import com.pogodin.wp.items.Symbol;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
