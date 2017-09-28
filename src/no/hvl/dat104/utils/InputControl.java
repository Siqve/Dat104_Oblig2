package no.hvl.dat104.utils;

import java.util.regex.Pattern;

public class InputControl {

	public static boolean isValidData(String fName, String sName, String phNr) {
		return (isValidFornavn(fName) && isValidEtternavn(sName) && isValidMobilnummer(phNr));
	}
	
	private static boolean isValidFornavn(String fName) {
		return Character.isUpperCase(fName.charAt(0)) && Pattern.matches("[a-zA-Z]+", fName);
	}
	
	private static boolean isValidEtternavn(String sName) {
		return Character.isUpperCase(sName.charAt(0)) && Pattern.matches("[a-zA-Z]+", sName);
	}
	
	private static boolean isValidMobilnummer(String phNr) {
		return (phNr.length() == 8 && phNr.matches("[0-9]+"));
	}
}
