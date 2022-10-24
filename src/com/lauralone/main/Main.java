package com.lauralone.main;

import com.lauralone.main.logic.TranslationManager;

public class Main {
	
	public static void main(String[] args) {
		
//		Alphabet european = new EuropeanCharacters();
//		Alphabet morse = new MorseCode();
//		Alphabet braille = new BrailleSystem();
//
//		System.out.println(european.name + ", " + european.info);
//		System.out.println(morse.name + ", " + morse.info);
//		System.out.println(braille.name + ", " + braille.info);
		
		
		TranslationManager translationManager = new TranslationManager();
		
		System.out.println(translationManager.translate("hello"));
		System.out.println("=========================================================");
		System.out.println(translationManager.translate("hello world !"));
		System.out.println("=========================================================");
		System.out.println(translationManager.translate("P13") + " = k");
		System.out.println(translationManager.translate("P235P235P235") + " = !!!");
		System.out.println(translationManager.translate("P235 P235 P235") + " = !!!");
		System.out.println(translationManager.translate("P235/P235/P235") + " = !!!");
		System.out.println(translationManager.translate("P235//P235//P235") + " = ! ! !");
		System.out.println("=========================================================");
		System.out.println(translationManager.translate(".... . ._.. ._.. ___ _._.__") + " = hello!");
		System.out.println(translationManager.translate("...././._../._../___/_._.__") + " = hello!");
		System.out.println(translationManager.translate("...././._../._../___//_._.__") + " = hello !");
		System.out.println("=========================================================");
		System.out.println(translationManager.translate(".ji^_lh13iu !") + " (should fail, because not everything can be translated)");
		System.out.println(translationManager.translate("._._._ .--- .. ..__._ ._.. .... .____ ...__ .. .._ //_._.__") + " = .ji^_lh13iu ! -- to code and back to eu = .JI_LH13IU ! -- '^' is missing");
		System.out.println(translationManager.translate("P3 P245 P24 P456 P123 P125 P1 P14 P24 P136//P235") + " = .ji^_lh13iu ! -- to code and back to eu = .09_L8139U ! (braille has some double meanings 1 == a, 2 == b, etc.. - should fix? B'cuz not really often used, I guess ^^')");
	
		
	}
	
	/*
last output:

C:\Users\laura\.jdks\openjdk-16.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.1\lib\idea_rt.jar=59787:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\laura\Desktop\simpel-mb-translator\out\production\simpel-mb-translator com.lauralone.main.Main
New translation:
Code: Morse Code
info: Spacing and length of the signals
- A dash is equal to three dots.
- The space between the signals forming the same letter is equal to one dot.
- The space between two letters is equal to three dots.
- The space between two words is equal to seven dots.
Translation of: hello
.... . ._.. ._.. ___

New translation:
Code: Braille System
info: Points
[1] [4]
[2] [5]
[3] [6]
Translation of: hello
⠓ P125 ⠑ P15 ⠇ P123 ⠇ P123 ⠕ P135
=========================================================
New translation:
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

New translation:
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
K = k
!!! = !!!
!!! = !!!
!!! = !!!
! ! ! = ! ! !
=========================================================
HELLO! = hello!
HELLO! = hello!
HELLO ! = hello !
=========================================================
Translation failed for : .ji^_lh13iu ! (should fail, because not everything can be translated)
.JI_LH13IU ! = .ji^_lh13iu ! -- to code and back to eu = .JI_LH13IU ! -- '^' is missing
.09_L8139U ! = .ji^_lh13iu ! -- to code and back to eu = .09_L8139U ! (braille has some double meanings 1 == a, 2 == b, etc.. - should fix? B'cuz not really often used, I guess ^^')

Process finished with exit code 0
	 */
}
