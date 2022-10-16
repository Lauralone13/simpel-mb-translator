package com.lauralone.main.domain;

import java.util.List;

public abstract class Alphabet {

	String info;

	public Alphabet(String info) {
		this.info = info;
	}

	public abstract List<String> getLetters();

	public abstract List<String> compoundVowels();

	public abstract List<String> getNumbers();

	public abstract List<String> getSymbols();

}
