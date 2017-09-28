package no.hvl.dat104.utils;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class SessionControl {

	public static boolean isLoggedIn(HttpServletRequest request) {
		return request != null && request.getAttribute("activeUser") != null;
	}

	//TODO: change String mobilnr to Bruker bruker
	public static void logInUser(HttpServletRequest request, String mobilnr) {
		request.getSession().setAttribute("activeUser", mobilnr);
	}
	
	public static boolean isValidData(String fNavn, String eNavn, String mobNr) {
		return (isValidFornavn(fNavn) && isValidEtternavn(eNavn) && isValidMobilnummer(mobNr));
	}
	
	private static boolean isValidFornavn(String fNavn) {
		return Character.isUpperCase(fNavn.charAt(0)) && Pattern.matches("[a-zA-Z]+", fNavn);
	}
	
	private static boolean isValidEtternavn(String eNavn) {
		return Character.isUpperCase(eNavn.charAt(0)) && Pattern.matches("[a-zA-Z]+", eNavn);
	}
	
	private static boolean isValidMobilnummer(String mobNr) {
		return (mobNr.length() == 8 && mobNr.matches("[0-9]+"));
	}
}
