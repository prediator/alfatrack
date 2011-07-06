package com.pogodin.wp.items;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Cloneable {

	private List<SentencePart> parts;
	private List<Integer> wordIndices;

	public Sentence() {
		clear();
	}
	
	public Sentence(Sentence sentence){
		parts = new ArrayList<SentencePart>(sentence.parts);
		wordIndices = new ArrayList<Integer>(sentence.wordIndices);
	}
	
	public void addSentencePart(SentencePart part) {
		if (part.isWord()) {
			wordIndices.add(parts.size());
		}
		parts.add(part);
	}
	
	public SentencePart get(int index) {
		return parts.get(index);
	}

	@Override
	public String toString() {
		String result = "";

		for (SentencePart part : parts) {
			result += part.toString();
		}
		return result;
	}

	public int partsCount() {
		return parts.size();
	}

	public void clear() {
		parts = new ArrayList<SentencePart>();
		wordIndices = new ArrayList<Integer>(); 
	}
	
	public List<Word> getWords() {
		List<Word> result = new ArrayList<Word>();
		for (Integer i : wordIndices) {
			result.add((Word) parts.get(i));
		}
		return result;
	}
}
