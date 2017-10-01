package no.hvl.dat104.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.db.Participant;
import no.hvl.dat104.utils.FlashUtil;
import no.hvl.dat104.utils.InputControl;
import no.hvl.dat104.utils.URLMappings;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO: get participant-object from registration and check if not null
		// TODO: if registeredObject != null --> forward to confirmation page
		if (!request.getSession().isNew() && request.getSession().getAttribute("participant") != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_CONF_JSP_URL);
			dispatcher.forward(request, response);
		}

		// Forward to registerform.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_JSP_URL);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		checkAndRegister(request);
		response.sendRedirect(URLMappings.REGISTER_URL);
	}

	private void checkAndRegister(HttpServletRequest request) {

		// TODO: del opp inputsjekking og lag feilmelding for kvart tilfelle

		if (!checkParameters(request)) {
			FlashUtil.addErrorFlash(request, "Alle felter må fylles ut!");

		} else {

			String firstname, surname, phonenumber;

			firstname = request.getParameter("firstname");
			surname = request.getParameter("surname");
			phonenumber = request.getParameter("phonenumber");

			String formatError = "Feil format på ett eller flere av inndatafeltene. Prøv igjen.";

			if (!InputControl.isValidFornavn(firstname))
				FlashUtil.addErrorFlash(request, formatError);
			else if (!InputControl.isValidEtternavn(surname))
				FlashUtil.addErrorFlash(request, formatError);
			else if (!InputControl.isValidMobilnummer(phonenumber))
				FlashUtil.addErrorFlash(request, formatError);
			else
				registerParticipant(request);
		}
	}

	private void registerParticipant(HttpServletRequest request) {
		// TODO: Add mechanics for registering participant to DB here
		Participant part = new Participant();
		part.setFirstname(request.getParameter("firstname"));
		part.setSurname(request.getParameter("surname"));
		part.setPhonenumber(request.getParameter("phonenumber"));
		part.setSex(request.getParameter("sex"));
	
		request.getSession().setAttribute("participant", part);
	}

	private boolean checkParameters(HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String phonenumber = request.getParameter("phonenumber");

		return (!InputControl.isNullOrEmpty(firstname) && !InputControl.isNullOrEmpty(surname)
				&& !InputControl.isNullOrEmpty(phonenumber));
	}
}
