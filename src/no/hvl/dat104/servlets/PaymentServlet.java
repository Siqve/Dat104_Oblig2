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
import no.hvl.dat104.utils.InputControl;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ParticipantEAO partEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionControl.isLoggedInCashier(request)) {
			response.sendRedirect(URLMappings.LOGIN_URL_CASHIER);
			return;
		}

		List<Participant> participants = new ArrayList<>(partEAO.listAllParticipants());
		Collections.sort(participants);

		request.setAttribute("participants", participants);
		request.getRequestDispatcher(URLMappings.PAYMENTLIST_JSP_URL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String payer;

		if (request.getParameter("logout") != null) {
			SessionControl.logOutCashier(request);
			FlashUtil.addInfoFlash(request, "Du har blitt logget ut!");
		} else if ((payer = request.getParameter("payer")) != null && InputControl.isValidMobilnummer(payer)) {
			Participant part = partEAO.findParticipant(request.getParameter("payer"));
			if (part != null) {
				part.setPaid(!part.isPaid());
				partEAO.updateParticipant(part);
			}
		}
		response.sendRedirect(URLMappings.PAYMENTLIST_URL);
	}
}
