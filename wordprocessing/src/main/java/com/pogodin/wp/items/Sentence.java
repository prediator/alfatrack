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
				curWord = new ArrayList<Letter>();
				
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
	public SentencePart get(int index){
		return parts.get(index);
	}
	@Override
	public String toString(){
		String result = "";
		
		for(SentencePart part: parts){
			result += part.toSting();
		}
		return result;
	}
}
