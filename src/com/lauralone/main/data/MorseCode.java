package com.lauralone.main.data;

import java.util.HashMap;
import java.util.List;

public class MorseCode extends Alphabet {

	public MorseCode() {
		super("Morse Code",
		      "Spacing and length of the signals\n" +
				"- A dash is equal to three dots.\n" +
				"- The space between the signals forming the same letter is equal to one dot.\n" +
				"- The space between two letters is equal to three dots.\n" +
				"- The space between two words is equal to seven dots. ");
	}

	@Override
	public List<String> getLetters() {

		return List.of("._", "_...", "_._.", "_..", ".", ".._..", ".._.", "__.", "....", "..", ".---", "_._", "._..", "__", "_.", "___", ".__.", "__._", "._.", "...", "_", ".._", "..._", ".__", "_.._", "_.__", "__..", "._._", "___.", "..__", "...__..");
	}
	
	@Override
	public List<String> getCompoundVowels() {
		
		return List.of("-", "-", "-", "-", "-", "____", "-", "-");
	}
	
	public HashMap<String, String> getCompoundSignals() {
		
		HashMap<String, String> signals = new HashMap<>();
		signals.put("Error (or Erase)", "........");
		signals.put("Starting Signal", "_._._");
		signals.put("End of Message", "._._.");
		signals.put("Closing Down", "..._._");
		signals.put("Interval (Wait)", "._...");
		signals.put("Message Received", "._.");
		signals.put("Ready to Receive", "_._");
		signals.put("Distress Call (or SOS)", "...___...");
		
		return signals;
	}
	
	@Override
	public List<String> getNumbers() {

		return List.of("_____", ".____", "..___", "...__", "...._", ".....", "_....", "__...", "___..", "____.");
	}

	@Override
	public List<String> getSymbols() {

		return List.of("._._._", "__..__", "___...", "..__..", "_._.__", ".____.", "_...._", "_.._.", "_.__.", "_.__._", "._.._.", "_..._", "._._.", "_.._", ".__._.", "._...", "_____ _.._. _____", "..._.._", "..__._", "_._._.");
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





