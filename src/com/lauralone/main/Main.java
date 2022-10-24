package com.lauralone.main;

import com.lauralone.main.data.Alphabet;
import com.lauralone.main.data.BrailleSystem;
import com.lauralone.main.data.EuropeanCharacters;
import com.lauralone.main.data.MorseCode;
import com.lauralone.main.logic.TranslationManager;

public class Main {
	
	public static void main(String[] args) {
		
		Alphabet european = new EuropeanCharacters();
		Alphabet morse = new MorseCode();
		Alphabet braille = new BrailleSystem();
		
		System.out.println(european.name + ", " + european.info);
		System.out.println(morse.name + ", " + morse.info);
		System.out.println(braille.name + ", " + braille.info);
		
		
		TranslationManager translationManager = new TranslationManager();
		
		System.out.println(translationManager.translate("hello"));
		System.out.println("=========================================================");
		System.out.println("=========================================================");
		System.out.println(translationManager.translate("hello world !"));
		System.out.println("=========================================================");
//		System.out.println(translationManager.translate("P13") + " = k");
//		System.out.println(translationManager.translate("P235P235P235") + " = !!!");
//		System.out.println(translationManager.translate("P235 P235 P235") + " = ! ! !");
//		System.out.println(translationManager.translate(".... . .___ .___ ___ _._.__") + " = hello!");
		
		
	}
}
