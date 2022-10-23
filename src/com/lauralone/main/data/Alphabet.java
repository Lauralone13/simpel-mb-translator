package com.lauralone.main.data;

import java.util.List;

public abstract class Alphabet {
	
	
	public String name;
	public String info;
	
	public Alphabet(String name, String info) {
		this.name = name;
		this.info = info;
	}
	
	public abstract List<String> getLetters();
	
	public abstract List<String> getCompoundVowels();
	
	public abstract List<String> getNumbers();
	
	public abstract List<String> getSymbols();
	
}
