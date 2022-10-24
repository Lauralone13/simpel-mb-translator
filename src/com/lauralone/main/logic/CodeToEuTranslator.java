package com.lauralone.main.logic;

import com.lauralone.main.data.Alphabet;
import com.lauralone.main.data.EuropeanCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CodeToEuTranslator {
	
	private final Alphabet europeanCharacters = new EuropeanCharacters();
	
	
	public String translateCode(String input, Alphabet codeSystem, String type) {
		
		var separatedCodesOfInput = getCleanInputAsList(input);
		String translation = "";
		
		if(separatedCodesOfInput.size() > 0) {
			HashMap<String, String> translationMap = getTranslationMap(codeSystem);
			
			translation = translateCodeToEu(separatedCodesOfInput, translationMap, type);
		}
		
		return translation;
	}
	
	private String translateCodeToEu(List<String> separatedCodesOfInput, HashMap<String, String> translationMap,
	                                 String type) {
		
		List<String> translatedValues = new ArrayList<>();
		
		for(String inputCode : separatedCodesOfInput) {
			
			if(inputCode.equals(" ")) {
				translatedValues.add(inputCode);
				continue;
			}
			
			for(String key : translationMap.keySet()) {
				String keyValue = translationMap.get(key);
				
				if(type.equals("braille")) {
					if(! keyValue.startsWith("P")) {
						keyValue = keyValue.substring(2);
					}
				}
				
				if(keyValue.equals(inputCode)) {
					
					translatedValues.add(key);
					break;
				}
			}
		}
		
		if(separatedCodesOfInput.size() == translatedValues.size()) {
			
			StringBuilder translation = new StringBuilder();
			
			for(String translatedValue : translatedValues) {
				
				translation.append(translatedValue);
			}
			
			return translation.toString().trim();
		}
		
		return "";
	}
	
	private HashMap<String, String> getTranslationMap(Alphabet codeSystem) {
		
		
		var euLists = List.of(europeanCharacters.getLetters(), europeanCharacters.getCompoundVowels(),
		                      europeanCharacters.getNumbers(), europeanCharacters.getSymbols());
		
		var codeLists = List.of(codeSystem.getLetters(), codeSystem.getCompoundVowels(), codeSystem.getNumbers(),
		                        codeSystem.getSymbols());
		
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
		
		var separatedCharacters = getSeparatedCharacters(input);
		List<String> cleanList = new ArrayList<>();
		
		String codeChars = "";
		
		if(separatedCharacters.size() > 0) {
			for(int i = 0; i < separatedCharacters.size(); i++) {
				
				String characterOfInput = separatedCharacters.get(i);
				
				if(characterOfInput.equals(" ") || characterOfInput.equals("/") || characterOfInput.equals("P")) {
					
					if(codeChars.length() > 0) {
						cleanList.add(codeChars);
					}
					if(characterOfInput.equals("P")) {
						codeChars = characterOfInput;
						continue;
					}
					
					codeChars = "";
					
					if(characterOfInput.equals("/") && separatedCharacters.get(i + 1).equals("/")) {
						cleanList.add(" ");
					}
					
				} else {
					
					codeChars = codeChars + characterOfInput;
					
					if(i == separatedCharacters.size() - 1) {
						cleanList.add(codeChars);
					}
				}
			}
		}
		
		return cleanList;
	}
}
