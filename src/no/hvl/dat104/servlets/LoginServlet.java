package no.hvl.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.utils.FlashUtil;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (SessionControl.isLoggedIn(request.getCookies())) {
			//Send to deltaker list
		}
		request.getRequestDispatcher(URLMappings.LOGIN_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkAndLogin(request);
		response.sendRedirect(URLMappings.LOGIN_URL);
	}
	
	
	public void checkAndLogin(HttpServletRequest request) {
		String mobilnr = request.getParameter("mobilnr");
		if (mobilnr == null || mobilnr.length() == 0) {
			FlashUtil.addInfoFlash(request, "Vennligst oppgi mobilnummer!");
			return;
		}
		
		//TODO: JPA hent alle passorder 
		//Bruker bruker = "SELECT * FROM "brukere" WHERE mobilnr = " + mobilnr
		//			request.getSession().setAttribute("activeUser", bruker);
		
		//Dummydata
		if (mobilnr.equals("97088875")) {
			//Gucci
			request.getSession().setAttribute("activeUser", mobilnr);
		} else {
			FlashUtil.addErrorFlash(request, "Bruker eksisterer ikke!");
		}
	}
}
