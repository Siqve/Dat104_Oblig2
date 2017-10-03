package no.hvl.dat104.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.db.Participant;
import no.hvl.dat104.db.ParticipantEAO;
import no.hvl.dat104.utils.FlashUtil;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ParticipantEAO partEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionControl.isLoggedInUser(request)) {
			response.sendRedirect(URLMappings.LOGIN_URL);
			return;
		}

		List<Participant> participants = new ArrayList<Participant>(partEAO.listAllParticipants());

		Collections.sort(participants);

		request.setAttribute("users", participants);
		request.getRequestDispatcher(URLMappings.USERLIST_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		checkAndLogout(request);
		response.sendRedirect(URLMappings.USERLIST_URL);
	}

	private void checkAndLogout(HttpServletRequest request) {
		String logout = request.getParameter("logout");

		if (logout != null) {
			SessionControl.logOutUser(request);
			FlashUtil.addInfoFlash(request, "Du har blitt logget ut!");
		}
	}

}
