package com.lauralone.main.data;

import java.util.List;

public class BrailleSystem extends Alphabet {

	public BrailleSystem() {
		super("Braille System", "Points\n[1] [4]\n[2] [5]\n[3] [6]");
	}

	@Override
	public List<String> getLetters() {

		return List.of("⠁ P1", "⠃ P12", "⠉ P14", "⠙ P145", "⠑ P15", "P123456", "⠋ P124", "⠛ P1245", "⠓ P125", "⠊ P24", "⠚ P245", "⠅ P13", "⠇ P123", "⠍ P134", "⠝ P1345", "⠕ P135", "⠏ P1234", "⠟ P12345", "⠗ P1235", "⠎ P234", "⠞ P2345", "⠥ P136", "⠧ P1236", "⠺ P2456", "⠭ P1346", "⠽ P13456", "⠵ P1356", "⠜ P345", "⠪ P246", "⠳ P1256", "⠮ P2346");
	}
	
	@Override
	public List<String> getCompoundVowels() {
		return List.of("P346", "P146", "P126", "P34", "P16", "P1456", "P156", "P23456");
	}
	
	@Override
	public List<String> getNumbers() {

		return List.of("⠚ P245", "⠁ P1", "⠃ P12", "⠉ P14", "⠙ P145", "⠑ P15", "⠋ P124", "⠛ P1245", "⠓ P125", "⠊ P24");
	}

	@Override
	public List<String> getSymbols() {

		return List.of("P3", "P2", "P25", "P26", "P235", "P6", "P36", "P256", "P2356", "P2356", "P4", "P2356", "P235", "P35", "P345", "P12346", "P123456", "P46", "P456", "P23");
	}
}
