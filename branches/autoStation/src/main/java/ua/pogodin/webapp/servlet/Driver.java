package ua.pogodin.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

public class Driver extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession currSession = req.getSession();
		User user = (User) currSession.getAttribute("user");
		JdbcConnection conn = new DataBaseConnector();
		List<BusApplication> apps = conn.findAllBusApplications();
		req.setAttribute("apps", apps);
		req.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/driver.jsp").forward(req, resp);
	}
}