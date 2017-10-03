package no.hvl.dat104.utils;

import java.util.regex.Pattern;

public class InputControl {

	public static boolean isValidFornavn(String fName) {
		return Pattern.matches("^[A-ZÆØÅ][a-zæøåA-ZÆØÅ -]{1,19}$", fName);
	}

	public static boolean isValidEtternavn(String sName) {
		return Pattern.matches("^[A-ZÆØÅ][a-zæøåA-ZÆØÅ-]{1,19}$", sName);
	}

	public static boolean isValidMobilnummer(String phNr) {
		return (phNr.matches("[0-9]{8}"));
	}

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}
}
