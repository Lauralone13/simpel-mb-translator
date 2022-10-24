package com.lauralone.main.logic;

import com.lauralone.main.data.Alphabet;
import com.lauralone.main.data.BrailleSystem;
import com.lauralone.main.data.EuropeanCharacters;
import com.lauralone.main.data.MorseCode;

import java.util.List;

public class TranslationManager {
	
	private final EuToCodeTranslator euTranslator = new EuToCodeTranslator();
	private final CodeToEuTranslator codeTranslator = new CodeToEuTranslator();
	
	private final Alphabet europeanCharacters = new EuropeanCharacters();
	private final Alphabet morseCode = new MorseCode();
	private final Alphabet brailleSystem = new BrailleSystem();
	
	
	private final String typeEu = "eu";
	private final String typeMorse = "morse";
	private final String typeBraille = "braille";
	
	
	public String translate(String input) {
		
		String translationType = findTranslationType(input);
		String translationResult = input;
		
		if(translationType.equals(typeMorse)) {
			
			// translate morse to eu
		}
		
		if(translationType.equals(typeBraille)) {
			
			// translate braille to eu
		}
		
		if(translationType.equals(typeEu)) {
			
			// if no type can be chosen yet:
			// translate eu to braille and morse
			translationResult = translateEuToMorseAndBraille(input);
		}
		
		return translationResult;
	}
	
	private String translateEuToMorseAndBraille(String input) {
		
		String translationResult = "";
		if(input.length() > 0) {
			String translationToMorse = euTranslator.translateEuToMorse(input, morseCode);
			
			translationResult = "Code: " + morseCode.name + "\ninfo: " + morseCode.info + "\nTranslation of: " + input + "\n" + translationToMorse;
			
			String translationToBraille = euTranslator.translateEuToBraille(input, brailleSystem);
			
			translationResult = translationResult + "\n\n" + "Code: " + brailleSystem.name + "\ninfo: " + brailleSystem.info + "\nTranslation of: " + input + "\n" + translationToBraille;
		}
		
		return translationResult;
	}
	
	public List<String> translateMorseToEu(String input) {
		// like translateFromEuToCode(), but inverted - need euKey instead of the codeValue ;)
		// thinking about a further class, to separate the types of translation (eu to code, and code to eu)
		//maybe also another class to build the sentences(?) hm...
		return List.of();
	}
	
	public List<String> translateBrailleToEu(String input) {
		
		return List.of();
	}
	
	private String findTranslationType(String input) {
		
		String type = "notFound";
		input = input.trim();
		
		int inputLength = input.length();
		
		if(inputLength > 0) {
			char inputFirstChar = input.charAt(0);
			
			if(inputFirstChar == ('.') || inputFirstChar == ('_')) {
				type = typeMorse;
				
				if(inputLength > 1) {
					char inputSecondChar = input.charAt(1);
					
					if(! (inputSecondChar == ('.') || inputSecondChar == ('_'))) {
						
						type = typeEu;
					}
				}
			}
			
			if(inputFirstChar == ('P')) {
				type = typeBraille;
				
				if(inputLength > 1) {
					String inputSecondChar = String.valueOf(input.charAt(1));
					
					var brailleStringNumbers = List.of("1", "2", "3", "4", "5", "6");
					
					if(! (brailleStringNumbers.contains(inputSecondChar))) {
						
						type = typeEu;
					}
				}
			}
			
			if(! (type.equals(typeMorse) || type.equals(typeBraille))) {
				type =  typeEu;
			}
		}
		
		return type;
	}
	
	
	// later, if the type can be chosen by the user
	private String checkTranslationType(String input, String chosenType) {
		String type = findTranslationType(input);
		
		if(type.equals(chosenType)) {
			return type;
		}
		
		return "Couldn't translate '" + input + "'. Please choose another translation-option or check your input.";
	}
}
