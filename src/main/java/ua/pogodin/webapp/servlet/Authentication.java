package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authentication extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//todo: forward to login jsp
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pass = req.getParameter("pass");
		HttpSession currSession = req.getSession(true);
		JdbcConnection conn = new DataBaseConnector();

		if (conn.isLoginFree(login)){
			currSession.setAttribute("message", true);
			resp.sendRedirect("/autoStation");
		}
		User user = conn.getUserByLogin(login);

		currSession.setAttribute("user", user);
		currSession.setAttribute("busApp", null);
		if (!pass.equals(user.getPassword())){
			currSession.setAttribute("message", true);
			resp.sendRedirect("/autoStation");
		}

		if (user.isDispatcher()){
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/dispatcher.jsp").forward(req, resp);
		} else{
			resp.sendRedirect("/autoStation/driver");
		}

	}
}
