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
import no.hvl.dat104.utils.URLMappings;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: JPA List<Deltaker> deltakere = hente liste over alle deltakere
		List<Participant> participant = new ArrayList<Participant>();
		Participant part = new Participant();
		part.setFirstname("bob");
		part.setSurname("bobbson");
		part.setSex("male");
		part.setPaid(false);
		participant.add(part);
		request.setAttribute("users", participant);
		request.getRequestDispatcher(URLMappings.USERLIST_URL).forward(request, response);
	}

}
