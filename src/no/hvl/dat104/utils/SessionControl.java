package no.hvl.dat104.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionControl {

	public static boolean isLoggedIn(HttpServletRequest request) {
		return isLoggedIn(request.getCookies());
	}

	public static boolean isLoggedIn(Cookie[] cookies) {
		if (cookies == null)
			return false;
		for (Cookie c : cookies) {
			if (c.getName().equals("active"))
				return true;
		}
		return false;
	}

	public static void giveActiveCookie(HttpServletResponse response, ServletContext servletContext) {
		int duration = 20;
		try {
			duration = Integer.parseInt(servletContext.getInitParameter("sessionTimeSeconds"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.addCookie(SessionControl.createActiveCookie(duration));
	}

	public static Cookie createActiveCookie(int duration) {
		Cookie c = new Cookie("active", "true");
		c.setMaxAge(duration);
		return c;
	}

}
