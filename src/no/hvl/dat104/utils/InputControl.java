package no.hvl.dat104.utils;

import java.util.regex.Pattern;

public class InputControl {
	
	public static boolean isValidFornavn(String fName) {
		return Pattern.matches("[a-zA-Z]+", fName);
	}
	
	public static boolean isValidEtternavn(String sName) {
		return Pattern.matches("[a-zA-Z]+", sName);
	}
	
	public static boolean isValidMobilnummer(String phNr) {
		return (phNr.length() == 8 && phNr.matches("[0-9]+"));
	}
}
