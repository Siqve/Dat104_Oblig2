package no.hvl.dat104.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.utils.InputControl;
import no.hvl.dat104.utils.SessionControl;
import no.hvl.dat104.utils.URLMappings;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//TODO: get user-object from registration and check if not null
		//TODO: if registeredObject != null --> forward to confirmation page
		
		
		// Forward to registerform.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_JSP_URL);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (checkAndRegister(request)) {
			// System.out.println("----BREAKPOINT----");
			// Register user/update DB accordingly and send to confirmation.jsp
			
			// TODO: Must set session attribute before redirecting
			response.sendRedirect(URLMappings.REGISTER_URL);
		} else {
			response.sendRedirect(URLMappings.REGISTER_URL);
		}
		
		response.sendRedirect(URLMappings.REGISTER_URL);
	}

	private boolean checkAndRegister(HttpServletRequest request) {

		if (checkParameters(request)) {
			System.out.println("----BREAKPOINT----");
			String firstname, surname, phonenumber;
			firstname = request.getParameter("firstname");
			surname = request.getParameter("surname");
			phonenumber = request.getParameter("phonenumber");

			return (InputControl.isValidData(firstname, surname, phonenumber));
		}

		return false;
	}

	private boolean checkParameters(HttpServletRequest request) {
		return (request.getParameter("firstname") != null && request.getParameter("surname") != null
				&& request.getParameter("phonenumber") != null);
	}
}
