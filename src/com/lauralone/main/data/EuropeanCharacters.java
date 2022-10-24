package com.lauralone.main.data;

import java.util.List;

public class EuropeanCharacters extends Alphabet {
	
	public EuropeanCharacters() {
		super("European Characters", "German and English Letters, and international Symbols");
	}
	
	@Override
	public List<String> getLetters() {
		
		return List.of("A", "B", "C", "D", "E", "É", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "Ä", "Ö", "Ü", "ß");
	}
	
	@Override
	public List<String> getCompoundVowels() {
		
		return List.of("ie", "ei", "eu", "äu", "au", "ch", "sch", "st");
	}
	
	@Override
	public List<String> getNumbers() {
		
		return List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
	}
	
	@Override
	public List<String> getSymbols() {
		
		return List.of(".", ",", ":", "?", "!", "'", "-", "/", "(", ")", "\"", "=", "+", "x/*", "@", "&", "%", "$", "_", ";");
	}
}
