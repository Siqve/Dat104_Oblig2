package no.hvl.dat104.servlets;

import java.io.IOException;

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

		if(checkAndRegister(request)) {
			// Register user/update DB accordingly and send to confirmation.jsp
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_CONF_JSP_URL);
			dispatcher.forward(request, response);
		}
		
		// Forward to registerform.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_JSP_URL);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean checkAndRegister(HttpServletRequest request) {

		String firstname, surname, phonenumber;
		firstname = request.getParameter("firstname");
		surname = request.getParameter("surname");
		phonenumber = request.getParameter("phonenumber");

		return (InputControl.isValidData(firstname, surname, phonenumber));
	}
}
