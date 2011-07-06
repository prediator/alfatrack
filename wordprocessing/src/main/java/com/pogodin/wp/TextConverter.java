package com.pogodin.wp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pogodin.wp.items.Letter;
import com.pogodin.wp.items.Sentence;
import com.pogodin.wp.items.Word;

//TODO laets make this class the main one. Place here main() and invoke FileReader,SentenceParser and others
//TODO create the method (not main) which loads from file, converts and saves, write a test to this method
//TODO create a simple main() which just creates TextConverter object and invokes the just writed method
//have you just written "enough" ?  yeah
//OK
//TODO please figure out, why in the window "Tasks" we can't see my TODOs

public class TextConverter {
	private String text;
	private Character symbol;

	public void setText(String text) {
		this.text = text;
	}

	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	protected String convertToSortedWords() {
		if (symbol == null || "".equals(text)) {
			return text;
		}

		SentenceParser parser = SentenceParser.getInstance();
		List<Word> wordPack = new ArrayList<Word>();
		WordConverter wc = new WordConverter(new Letter(symbol.charValue()));

		for (Sentence cur : parser.parseSentences(text)) {
			wordPack.addAll(cur.getWords());
		}

		Collections.sort(wordPack, wc);

		String result = "";
		for (Word iterWord : wordPack) {
			result += iterWord.toString() + " ";
		}

		return result;
	}
	public void readWriteConvert(String getFromPath, String outToPath, char inpSymbol){
		
		String fileText = FileReaderWriter.readFile(getFromPath);
		text = fileText;
		symbol = inpSymbol;
		
		String convertedText = convertToSortedWords();
		FileReaderWriter.writeFile(convertedText, outToPath);
		
		
	}
	public void main (String [] args){
		//String inputted = FileReaderWriter.readFile("some.txt");
		
		
		
		System.out.println();
	}
}
