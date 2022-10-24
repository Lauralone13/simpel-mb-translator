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
	
	/*
last output:

Code: Braille System
info: Points
[1] [4]
[2] [5]
[3] [6]
Translation of: hello
⠓ P125 ⠑ P15 ⠇ P123 ⠇ P123 ⠕ P135
=========================================================
=========================================================
Code: Morse Code
info: Spacing and length of the signals
- A dash is equal to three dots.
- The space between the signals forming the same letter is equal to one dot.
- The space between two letters is equal to three dots.
- The space between two words is equal to seven dots.
Translation of: hello world !
.... . ._.. ._.. ___
.__ ___ ._. ._.. _..
_._.__

Code: Braille System
info: Points
[1] [4]
[2] [5]
[3] [6]
Translation of: hello world !
⠓ P125 ⠑ P15 ⠇ P123 ⠇ P123 ⠕ P135
⠺ P2456 ⠕ P135 ⠗ P1235 ⠇ P123 ⠙ P145
P235
=========================================================

Process finished with exit code 0

	 */
}
