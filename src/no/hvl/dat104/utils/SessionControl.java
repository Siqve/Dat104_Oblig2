package no.hvl.dat104.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionControl {

	public static boolean isLoggedIn(HttpServletRequest request) {
		return request != null && request.getAttribute("activeUser") != null;
	}

	//TODO: change String mobilnr to Bruker bruker
	public static void logInUser(HttpServletRequest request, String mobilnr) {
		request.getSession().setAttribute("activeUser", mobilnr);
	}
}
