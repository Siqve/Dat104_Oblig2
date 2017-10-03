package no.hvl.dat104.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.db.Participant;
import no.hvl.dat104.db.ParticipantEAO;
import no.hvl.dat104.utils.ErrorUtils;
import no.hvl.dat104.utils.FlashUtil;
import no.hvl.dat104.utils.InputControl;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ParticipantEAO partEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!request.getSession().isNew() && request.getSession().getAttribute("activeUser") != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_CONF_JSP_URL);
			dispatcher.forward(request, response);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_JSP_URL);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		checkAndRegister(request, response);
		response.sendRedirect(URLMappings.REGISTER_URL);
	}

	private void checkAndRegister(HttpServletRequest request, HttpServletResponse response) {

		boolean register = true;
		register = validateInput(request, response);

		if (register)
			registerParticipant(request);
	}

	private boolean validateInput(HttpServletRequest request, HttpServletResponse response) {

		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String phonenumber = request.getParameter("phonenumber");

		boolean firstnameValid = InputControl.isValidFornavn(firstname);
		boolean surnameValid = InputControl.isValidEtternavn(surname);
		boolean phonenumberValid = InputControl.isValidMobilnummer(phonenumber);

		if (!firstnameValid || !surnameValid || !phonenumberValid) {
			FlashUtil.addErrorFlash(request, ErrorUtils.FORMAT_ERROR);

			if (firstnameValid) {
				Cookie cookie = new Cookie("validFirstname", firstname);
				cookie.setMaxAge(30);
				response.addCookie(cookie);
			}

			if (surnameValid) {
				Cookie cookie = new Cookie("validSurname", surname);
				cookie.setMaxAge(30);
				response.addCookie(cookie);
			}

			if (phonenumberValid) {

				if (partEAO.phonenumberExists(phonenumber)) {
					FlashUtil.addErrorFlash(request, ErrorUtils.EXISTS_ERROR);
					return false;
				}

				Cookie cookie = new Cookie("validPhonenumber", phonenumber);
				cookie.setMaxAge(30);
				response.addCookie(cookie);
			}
			return false;
		}

		if (!checkParameters(request)) {
			FlashUtil.addErrorFlash(request, ErrorUtils.ALL_FIELDS_ERROR);
			return false;
		}

		return true;
	}

	private void registerParticipant(HttpServletRequest request) {

		Participant part = new Participant();
		part.setFirstname(request.getParameter("firstname"));
		part.setSurname(request.getParameter("surname"));
		part.setPhonenumber(request.getParameter("phonenumber"));
		part.setSex(Boolean.valueOf(request.getParameter("sex")));
		part.setPaid(false);

		partEAO.addParticipant(part);

		SessionControl.logInUser(request, part);
	}

	private boolean checkParameters(HttpServletRequest request) {
		String firstname = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String phonenumber = request.getParameter("phonenumber");

		return (!InputControl.isNullOrEmpty(firstname) && !InputControl.isNullOrEmpty(surname)
				&& !InputControl.isNullOrEmpty(phonenumber));
	}
}
