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

@WebServlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Antar at login er ett brukstilfelle, men at aktør enten er "deltaker" eller
		// "kasserer". Bruker derfor samme servlet.

		if (SessionControl.isLoggedInUser(request)) {
			response.sendRedirect(URLMappings.USERLIST_URL);
			return;
		} else if (SessionControl.isLoggedInCashier(request)) {
			response.sendRedirect(URLMappings.PAYMENTLIST_URL);
			return;
		}

		if (request.getSession().isNew()) {
			setParticipantLogin(request);
		} else {
			if (request.getParameter("cashier") != null) {
				setCashierLogin(request);
			} else {
				setParticipantLogin(request);
			}
		}
		request.getRequestDispatcher(URLMappings.LOGIN_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Husk meg button
		checkAndLogin(request, request.getParameter("cashier"));
		response.sendRedirect(URLMappings.LOGIN_URL);
	}

	private void setCashierLogin(HttpServletRequest request) {
		request.setAttribute("loginmethod", "cashier");
		request.setAttribute("logintext", "Kasserer login: ");
		request.setAttribute("inputtype", "cashierpwd");
		request.setAttribute("inputplaceholder", "Passord");
	}

	private void setParticipantLogin(HttpServletRequest request) {
		request.setAttribute("loginmethod", "participant");
		request.setAttribute("logintext", "Logg inn: ");
		request.setAttribute("inputtype", "phonenumber");
		request.setAttribute("inputplaceholder", "Mobilnummer");
	}

	public void checkAndLogin(HttpServletRequest request, String cashierParsed) {
		boolean cashier;
		try {
			cashier = Boolean.valueOf(cashierParsed);
		} catch (Exception e) {
			cashier = false;
		}
		
		if (!cashier) { // Utfør checkAndLogin for "participant"

			String mobilnr = request.getParameter("phonenumber");
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

		} else { // Utfør checkAndLogin for "cashier"

			// request.getParameter("cashierpwd");
			String passord = getServletConfig().getInitParameter("cashierpwd");

			if (InputControl.isNullOrEmpty(passord)) {
				FlashUtil.addInfoFlash(request, "Vennligst oppgi passord.");
				return;
			}

			// TODO: hent initparam cashier-passord

			// Dummydata
			if (passord.equals("pass")) {
				SessionControl.logInCashier(request);
			} else {
				FlashUtil.addErrorFlash(request, "Feil passord!");
			}
		}
	}
}
