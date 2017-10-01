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
			if (request.getParameter("loginmethod") == null
					|| request.getParameter("loginmethod").equals("participant")) {
				// TODO: Set session-attributt "loginmethod" = cashier
				setParticipantLogin(request);
			} else if (request.getParameter("loginmethod").equals("cashier")) {
				// TODO: Set session-attributt "loginmethod" = deltaker
				setCashierLogin(request);
			}
		}

		request.getRequestDispatcher(URLMappings.LOGIN_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Husk meg button
		// TODO: Velge check-metode; "participant" eller "cashier"
		checkAndLogin(request, (String) request.getSession().getAttribute("loginmethod"));
		response.sendRedirect(URLMappings.LOGIN_URL);
	}

	private void setCashierLogin(HttpServletRequest request) {
		request.getSession().setAttribute("loginmethod", "cashier");
		request.getSession().setAttribute("logintext", "Kasserer login: ");
		request.getSession().setAttribute("inputtype", "cashierpwd");
		request.getSession().setAttribute("inputplaceholder", "Passord");
	}

	private void setParticipantLogin(HttpServletRequest request) {
		request.getSession().setAttribute("loginmethod", "participant");
		request.getSession().setAttribute("logintext", "Logg inn: ");
		request.getSession().setAttribute("inputtype", "phonenumber");
		request.getSession().setAttribute("inputplaceholder", "Mobilnummer");
	}

	public void checkAndLogin(HttpServletRequest request, String loginmethod) {

		if (loginmethod.equals("participant")) { // Utfør checkAndLogin for "participant"

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
			
		} else if (loginmethod.equals("cashier")) { // Utfør checkAndLogin for "cashier"

			String passord = request.getParameter("cashierpwd");
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
