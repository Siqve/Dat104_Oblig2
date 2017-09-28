package no.hvl.dat104.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.utils.URLMappings;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Sjekk om alle parameter er fylt ut + gyldige
		// Påmeldingsbekreftelse
		// Redirect til login-servlet/deltakarliste
		
		
		// Forward to registerform.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(URLMappings.REGISTER_JSP_URL);
		dispatcher.forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
