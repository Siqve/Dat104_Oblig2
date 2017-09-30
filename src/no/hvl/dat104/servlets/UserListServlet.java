package no.hvl.dat104.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.db.Participant;
import no.hvl.dat104.utils.FlashUtil;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionControl.isLoggedIn(request)) {
			response.sendRedirect(URLMappings.LOGIN_URL);
			return;
		}
		
		// TODO: JPA List<Deltaker> deltakere = hente liste over alle deltakere
		List<Participant> participant = new ArrayList<Participant>();
		Participant part = new Participant();
		part.setFirstname("bob");
		part.setSurname("bobbson");
		part.setSex("male");
		part.setPaid(false);
		participant.add(part);
		request.setAttribute("users", participant);
		
		request.getRequestDispatcher(URLMappings.USERLIST_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkAndLogout(request);
		response.sendRedirect(URLMappings.USERLIST_URL);
	}

	private void checkAndLogout(HttpServletRequest request) {
		String logout = request.getParameter("logout");
		
		// Logout has been pressed
		if (logout != null) {
			SessionControl.logOutUser(request);
			FlashUtil.addInfoFlash(request, "Du har blitt logget ut!");
		}
	}

}
