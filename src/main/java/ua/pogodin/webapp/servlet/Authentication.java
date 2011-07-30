package ua.pogodin.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.User;

public class Authentication extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		HttpSession currSession = req.getSession(true);
		JdbcConnection conn = new DataBaseConnector();
		req.setAttribute("message", 1);

		if (conn.isLoginFree(login)) {
			resp.sendRedirect("/autoStation");
		}
		User user = conn.getUserByLogin(login);
		
		if (!pass.equals(user.getPassword())) {
			resp.sendRedirect("/autoStation");
		}
		currSession.setAttribute("user", user);

		if (user.isDispatcher()) {
			resp.sendRedirect("/autoStation/dispatcher");
		} else {
			resp.sendRedirect("/autoStation/driver");
		}

	}
}
