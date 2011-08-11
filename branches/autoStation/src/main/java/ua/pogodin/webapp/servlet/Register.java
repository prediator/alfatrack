package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import java.io.IOException;
import java.net.HttpRetryException;
import java.util.List;

public class Register extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!((User)req.getSession().getAttribute("user")).isIsDispatcher()){
			resp.sendRedirect("driver");
		}
		forward("/WEB-INF/jsp/register.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pass1 = (String) req.getParameter("pass1");
		String pass2 = (String) req.getParameter("pass2");
		String login = (String) req.getParameter("login");
		String name = (String) req.getParameter("name");

		boolean loginTaken = ((login == null) || !dbConnector.isLoginFree(login));
		boolean isPassWrong = ((pass1 == null) || (pass2 == null) || !pass1.equals(pass2));
		boolean notNameInputted = (name == null);

		req.setAttribute("loginTaken", loginTaken);
		req.setAttribute("isPassWrong", isPassWrong);
		req.setAttribute("notNameInputted", notNameInputted);
		req.setAttribute("name", name);
		req.setAttribute("login", login);

		if (loginTaken || notNameInputted || isPassWrong) {
			forward("/WEB-INF/jsp/register.jsp", req, resp);
		} else {
			boolean disp = ((String) req.getParameter("isDispatcher")).equals("dispatcher");
			if (disp) {
				createDispatcher(resp, login, pass1, name);
			} else {
				int busload = Integer.valueOf((String) req.getParameter("busload")).intValue();
				int maxspeed = Integer.valueOf((String) req.getParameter("maxspeed")).intValue();
				String busWorking = (String) req.getParameter("busworking");

				if (busload > 0 && maxspeed > 0) {
					createDriver(resp, login, pass1, name, busload, maxspeed,
							(busWorking != null) ? busWorking.equals("true") : false);
				} else {
					forward("/WEB-INF/jsp/register.jsp", req, resp);
				}
			}
		}
	}

	private void createDriver(HttpServletResponse resp, String login, String pass, String name, int busload,
			int maxspeed, boolean isWork) throws IOException {
		Bus bus = new Bus(busload, maxspeed, isWork);
		dbConnector.createBus(bus);
		dbConnector.createUser(new User(login, pass, name, false, bus));
		resp.sendRedirect("users");
	}

	private void createDispatcher(HttpServletResponse resp, String login, String pass, String name) throws IOException {
		dbConnector.createUser(new User(login, pass, name, true, new Bus()));
		resp.sendRedirect("users");
	}
}
