package no.hvl.dat104.utils;

import javax.servlet.http.HttpServletRequest;

public class FlashUtil {
	
	public static void addFlash(HttpServletRequest request, String type, String message) {
		request.getSession().setAttribute("flash", type);
		request.getSession().setAttribute("flashmessage", message);
	}
	
	public static void addErrorFlash(HttpServletRequest request, String message) {
		addFlash(request, "danger", message);
	}
	
	public static void addInfoFlash(HttpServletRequest request, String message) {
		addFlash(request, "info", message);
	}
	
	public static void addSuccessFlash(HttpServletRequest request, String message) {
		addFlash(request, "success", message);
	}

}
