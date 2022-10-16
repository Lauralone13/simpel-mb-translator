package com.lauralone.main.domain;

import java.util.List;

public class MorseCode extends Alphabet {

	public MorseCode(String info) {
		super(info);
	}

	@Override
	public List<String> getLetters() {

		return List.of("._", "_...", "_._.", "_..", ".", ".._..", ".._.", "__.", "....", "..", ".---", "_._", "._..", "__", "_.", "___", ".__.", "__._", "._.", "...", "_", ".._", "..._", ".__", "_.._", "_.__", "__..", "._._", "___.", "..__", "...__..");
	}

	@Override
	public List<String> compoundVowels() {
		return List.of("ie", "ei", "eu", "äu", "au", "ch", "sch", "st");
	}

	@Override
	public List<String> getNumbers() {

		return List.of("_____", ".____", "..___", "...__", "...._", ".....", "_....", "__...", "___..", "____.");
	}

	@Override
	public List<String> getSymbols() {

		return List.of("._._._", "__..__", "___...", "..__..", "_._.__", ".____.", "_...._", "_.._.", "_.__.", "_.__._", "._.._.", "_..._", "._._.", "_.._", ".__._.", "._...", "_____ _.._. _____", "..._.._", "..__._");
	}
}

	// https://morsecode.world/international/morse2.html
	// could be more, like:
	// ch = ____
	// proSigns (AA - new line (._ ._), SN/VE - understood, HH - Error (...........)
	// % = 0/0 (_____ _.._. _____)
/*
Ein Funkspruch beginnt stets mit der Eröffnung − · − · − (KA)
Beendet wird der Funkspruch mit · − · − · (AR)
Eine Pause legen Sie mit − · · · − (BT) ein
Mit · · · − · (VE) bestätigen Sie, dass Sie verstanden haben
Den Funkkontakt beenden Sie mit · · · − · − (SK)
Bei einem Fehler senden Sie · · · · · · · · (HH) um das letzte Wort noch einmal zu wiederholen
 */





