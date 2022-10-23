package com.lauralone.main.logic;

import com.lauralone.main.data.Alphabet;
import com.lauralone.main.data.BrailleSystem;
import com.lauralone.main.data.EuropeanCharacters;
import com.lauralone.main.data.MorseCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TranslationCalculator {
	
	private final Alphabet europeanCharacters = new EuropeanCharacters();
	private final Alphabet morseCode = new MorseCode();
	private final Alphabet brailleSystem = new BrailleSystem();
	
	
	public String translateEuToMorse(String input) {
		
		var separatedCharsOfInput = getCleanInputAsList(input);
		
		HashMap<String, String> translationMap = getTranslationMap(morseCode.getLetters(), morseCode.getCompoundVowels(), morseCode.getNumbers(), morseCode.getSymbols());
		
		return translateFromEuToCode(separatedCharsOfInput, translationMap);
	}
	
	public String translateEuToBraille(String input) {
		
		var separatedCharsOfInput = getCleanInputAsList(input);
		
		HashMap<String, String> translationMap = getTranslationMap(brailleSystem.getLetters(), brailleSystem.getCompoundVowels(), brailleSystem.getNumbers(), brailleSystem.getSymbols());
		
		return translateFromEuToCode(separatedCharsOfInput, translationMap);
	}
	
	public List<String> translateMorseToEu(String input) {
		return List.of();
	}
	
	public List<String> translateBrailleToEu(String input) {
		return List.of();
	}
	
	private String translateFromEuToCode(List<String>separatedCharsOfInput, HashMap<String, String> translationMap) {
		
		List<String> translatedValues = new ArrayList<>();
		
		for(String inputChar : separatedCharsOfInput) {
			
			if(inputChar.equals(" ")) {
				translatedValues.add(inputChar);
				continue;
			}
			
			for(String key : translationMap.keySet()) {
				
				if(key.equalsIgnoreCase(inputChar)) {
					
					String translatedValue = translationMap.get(key);
					translatedValues.add(translatedValue);
					break;
				}
			}
		}
		
		String translation = "";
		
		for(String translatedValue : translatedValues) {
			
			if(translatedValue.equals(" ")) {
				translation = translation + "\n";
			} else {
				translation = translation + translatedValue + " ";
			}
		}
		
		return translation.trim();
	}
	
	private String translateFromCodeToEu() {
		
		// like translateFromEuToCode(), but inverted - need euKey instead of the codeValue ;)
		
		return "";
	}
	
	private List<String> getSeparatedCharacters(String input) {
		List<String> separatedCharacters = new ArrayList<>();
		
		if(input.length() > 0) {
			separatedCharacters = List.of(input.split(""));
		}
		
		return separatedCharacters;
	}
	
	private List<String> getCleanInputAsList(String input) {
		
		var separatedInputCharacters = getSeparatedCharacters(input);
		List<String> cleanList = new ArrayList<>();
		
		for(int i = 0; i < separatedInputCharacters.size(); i++) {
			
			String characterOfInput = separatedInputCharacters.get(i);
			
			if(characterOfInput.equals(" ")) {
				if(separatedInputCharacters.get(i + 1).equals(" ")) {
					continue;
				}
			}
			
			cleanList.add(characterOfInput);
		}
		
		return cleanList;
	}
	
	private HashMap<String, String> getTranslationMap( List<String> valueListLetters, List<String> valueListVowels, List<String> valueListNumbers, List<String> valueListSymbols) {
		
		var euLetters = europeanCharacters.getLetters();
		var euCompoundVowels = europeanCharacters.getCompoundVowels();
		var euNumbers = europeanCharacters.getNumbers();
		var euSymbols = europeanCharacters.getSymbols();
		var euLists = List.of(euLetters, euCompoundVowels, euNumbers, euSymbols);
		
		var codeLists = List.of(valueListLetters, valueListVowels, valueListNumbers, valueListSymbols);
		
		HashMap<String, String> translationMap = new HashMap<>();
		
		int index = 0;
		for(List<String> singleEuList : euLists) {
			List<String> singleCodeList = codeLists.get(index);
			
			if(singleEuList.size() == singleCodeList.size()) {
				for(int i = 0; i < singleEuList.size(); i++) {
					
					String euListEntry = singleEuList.get(i);
					String translationValue = singleCodeList.get(i);
					translationMap.put(euListEntry, translationValue);
				}
			}

			index++;
		}
		
		return translationMap;
	}
}
