package no.hvl.dat104.utils;

import javax.servlet.http.HttpServletRequest;

import no.hvl.dat104.db.Participant;

public class SessionControl {

	public static boolean isLoggedIn(HttpServletRequest request) {
		return request != null && request.getSession().getAttribute("activeUser") != null;
	}

	public static void logInUser(HttpServletRequest request, Participant participant) {
		request.getSession().setAttribute("activeUser", participant);
	}

	public static void logOutUser(HttpServletRequest request) {
		request.getSession().removeAttribute("activeUser");
	}

}
