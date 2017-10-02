package no.hvl.dat104.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.db.Participant;
import no.hvl.dat104.utils.FlashUtil;
import no.hvl.dat104.utils.InputControl;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (SessionControl.isLoggedIn(request)) {
			response.sendRedirect(URLMappings.USERLIST_URL);
			return;
		}
		request.getRequestDispatcher(URLMappings.LOGIN_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO: Husk meg button
		checkAndLogin(request);
		response.sendRedirect(URLMappings.LOGIN_URL);
	}

	public void checkAndLogin(HttpServletRequest request) {
		String mobilnr = request.getParameter("mobilnr");
		if (InputControl.isNullOrEmpty(mobilnr)) {
			FlashUtil.addInfoFlash(request, "Vennligst oppgi mobilnummer!");
			return;
		}

		// TODO: JPA hent alle passorder
		// Bruker bruker = "SELECT * FROM "brukere" WHERE mobilnr = " + mobilnr
		// request.getSession().setAttribute("activeUser", bruker);

		// Dummydata
		if (mobilnr.equals("97088875")) {
			Participant part = new Participant();
			part.setFirstname("bob");
			part.setSurname("bobbson");
			part.setPhonenumber(mobilnr);
			part.setSex("male");
			part.setPaid(false);
			SessionControl.logInUser(request, part);
		} else {
			FlashUtil.addErrorFlash(request, "Bruker eksisterer ikke!");
		}
	}
}
