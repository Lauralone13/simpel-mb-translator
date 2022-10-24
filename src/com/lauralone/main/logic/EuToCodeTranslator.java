package com.lauralone.main.logic;

import com.lauralone.main.data.Alphabet;
import com.lauralone.main.data.EuropeanCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EuToCodeTranslator {
	
	private final Alphabet europeanCharacters = new EuropeanCharacters();
	
	public String translateEuToMorse(String input, Alphabet morseCode) {
		
		var separatedCharsOfInput = getCleanInputAsList(input);
		String translation = "";
		
		if(separatedCharsOfInput.size() > 0) {
			HashMap<String, String> translationMap = getTranslationMap(morseCode.getLetters(), morseCode.getCompoundVowels(), morseCode.getNumbers(), morseCode.getSymbols());
			
			translation = translateFromEuToCode(separatedCharsOfInput, translationMap);
		}
		return translation;
	}
	
	public String translateEuToBraille(String input, Alphabet brailleSystem) {
		
		var separatedCharsOfInput = getCleanInputAsList(input);
		String translation = "";
		
		if(separatedCharsOfInput.size() > 0) {
			HashMap<String, String> translationMap = getTranslationMap(brailleSystem.getLetters(), brailleSystem.getCompoundVowels(), brailleSystem.getNumbers(), brailleSystem.getSymbols());
			
			translation = translateFromEuToCode(separatedCharsOfInput, translationMap);
			
		}
		return translation;
	}
	
	private String translateFromEuToCode(List<String> separatedCharsOfInput, HashMap<String, String> translationMap) {
		
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
		if(separatedCharsOfInput.size() == translatedValues.size()) {
			
			StringBuilder translation = new StringBuilder();
			
			for(String translatedValue : translatedValues) {
				
				if(translatedValue.equals(" ")) {
					translation.append("\n");
				} else {
					translation.append(translatedValue).append(" ");
				}
			}
			
			return translation.toString().trim();
		}
		
		return "";
	}
	
	private HashMap<String, String> getTranslationMap(List<String> valueListLetters, List<String> valueListVowels, List<String> valueListNumbers, List<String> valueListSymbols) {
		
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
	
	private List<String> getSeparatedCharacters(String input) {
		
		List<String> separatedCharacters = new ArrayList<>();
		
		if(input.length() > 0) {
			if(input.length() > 1) {
				separatedCharacters = List.of(input.split(""));
			} else {
				separatedCharacters.add(input);
			}
		}
		
		return separatedCharacters;
	}
	
	private List<String> getCleanInputAsList(String input) {
		
		var separatedInputCharacters = getSeparatedCharacters(input);
		List<String> cleanList = new ArrayList<>();
		
		if(separatedInputCharacters.size() > 0) {
			for(int i = 0; i < separatedInputCharacters.size(); i++) {
				
				String characterOfInput = separatedInputCharacters.get(i);
				
				if(characterOfInput.equals(" ")) {
					if(separatedInputCharacters.get(i + 1).equals(" ")) {
						continue;
					}
				}
				
				cleanList.add(characterOfInput);
			}
		}
		
		return cleanList;
	}
}
