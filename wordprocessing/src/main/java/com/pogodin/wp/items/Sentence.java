package com.pogodin.wp.items;

import java.util.ArrayList;
import java.util.List;

public class Sentence {

	List<SentencePart> parts;
	
	public Sentence(){
		parts = new ArrayList<SentencePart>();
	}
	
	public void setSentence(String input){
		input = input.replaceAll("[\\r,\\n,\\t, ]+", " ");
		
		List<Letter> curWord = new ArrayList<Letter>(); 
		
		for(char cur : input.toCharArray()){
			if(Character.isLetter(cur)){
				curWord.add(new Letter(cur));
			}
			else{
				parts.add(new Word(curWord));
				curWord.clear();
				
				if(Character.isSpaceChar(cur)){
					parts.add(new Space());
				}
				else{
					parts.add(new Mark(cur));
				}
			}
		}
		if(!curWord.isEmpty()){
			parts.add(new Word(curWord));
		}
	}
}
