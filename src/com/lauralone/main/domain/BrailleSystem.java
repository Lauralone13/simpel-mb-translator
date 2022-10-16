package com.lauralone.main.domain;

import java.util.List;

public class BrailleSystem extends Alphabet {

	public BrailleSystem(String info) {
		super(info);
	}

	/*
	Points
	[1] [4]
	[2] [5]
	[3] [6]
	 */


	@Override
	public List<String> getLetters() {

		return List.of("⠁ P1", "⠃ P12", "⠉ P14", "⠙ P145", "⠑ P15", "P123456", "⠋ P124", "⠛ P1245", "⠓ P125", "⠊ P24", "⠚ P245", "⠅ P13", "⠇ P123", "⠍ P134", "⠝ P1345", "⠕ P135", "⠏ P1234", "⠟ P12345", "⠗ P1235", "⠎ P234", "⠞ P2345", "⠥ P136", "⠧ P1236", "⠺ P2456", "⠭ P1346", "⠽ P13456", "⠵ P1356", "⠜ P345", "⠪ P246", "⠳ P1256", "⠮ P2346");
	}

	@Override
	public List<String> compoundVowels() {
		return List.of("P346", "P146", "P126", "P34", "P16", "P1456", "P156", "P23456");
	}

	@Override
	public List<String> getNumbers() {

		return List.of("⠚ P245", "⠁ P1", "⠃ P12", "⠉ P14", "⠙ P145", "⠑ P15", "⠋ P124", "⠛ P1245", "⠓ P125", "⠊ P24");
	}

	@Override
	public List<String> getSymbols() {

		return List.of(".", ",", ":", "?", "!", "'", "-", "/", "(", ")", "\"", "=", "+", "x", "@", "&", "%", "$", "_");
	}
}
