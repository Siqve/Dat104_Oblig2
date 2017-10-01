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
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!SessionControl.isLoggedInCashier(request)) {
			response.sendRedirect(URLMappings.LOGIN_URL_CASHIER);
			return;
		}
		
		// TODO: JPA List<Deltaker> deltakere = hente liste over alle deltakere
		List<Participant> participants = new ArrayList<Participant>();
		Participant part1 = new Participant();
		part1.setPhonenumber("12345678");
		part1.setFirstname("bob");
		part1.setSurname("bobbson");
		part1.setSex("male");
		part1.setPaid(false);
		participants.add(part1);
		
		Participant part2 = new Participant();
		part2.setPhonenumber("87654321");
		part2.setFirstname("anne");
		part2.setSurname("anneson");
		part2.setSex("female");
		part2.setPaid(true);
		participants.add(part2);
		
		request.setAttribute("participants", participants);
		request.getRequestDispatcher(URLMappings.PAYMENTLIST_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: Registrer og utf�r betaling
		// TODO: Hent parameter fra request som bestemmer hvilken "participant" som skal betale 
	}

}
