package com.lauralone.main;

import com.lauralone.main.data.Alphabet;
import com.lauralone.main.data.BrailleSystem;
import com.lauralone.main.data.EuropeanCharacters;
import com.lauralone.main.data.MorseCode;
import com.lauralone.main.logic.TranslationCalculator;

public class Main {
	
	public static void main(String[] args) {
		
		Alphabet european = new EuropeanCharacters();
		Alphabet morse = new MorseCode();
		Alphabet braille = new BrailleSystem();
		
		System.out.println(european.name + ", " + european.info);
		System.out.println(morse.name + ", " + morse.info);
		System.out.println(braille.name + ", " + braille.info);
		
		
		TranslationCalculator translationCalculator = new TranslationCalculator();
		
		System.out.println(translationCalculator.translateEuToMorse("hello"));
		System.out.println("=========================================================");
		System.out.println(translationCalculator.translateEuToBraille("hello"));
		System.out.println("=========================================================");
		System.out.println(translationCalculator.translateEuToMorse("hello world !"));
		System.out.println("=========================================================");
		System.out.println(translationCalculator.translateEuToBraille("hello world !"));
		
		
	}
}
