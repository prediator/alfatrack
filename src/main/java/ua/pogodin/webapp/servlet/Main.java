package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Main extends HttpServlet {

	private DataBaseConnector dbConn;
	
	@Override
	public void init() throws ServletException {
		dbConn = new DataBaseConnector();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = dbConn.findAllUsers();

		req.setAttribute("users", users);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(req, resp);
	}
}
