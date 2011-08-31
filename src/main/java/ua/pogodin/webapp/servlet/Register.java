package ua.pogodin.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.User;

public class Register extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!((User)req.getSession().getAttribute("user")).isDispatcher()){
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

		boolean loginTaken = ((login == null) || !dbJPAConnector.isLoginFree(login) || login.equals(""));
		boolean isPassWrong = ((pass1 == null) || (pass2 == null) || !pass1.equals(pass2) || pass1.equals(""));
		boolean notNameInputted = ((name == null) || name.equals(""));
 
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
		Driver driver = new Driver(login, pass, name, bus);
		bus.setDriver(driver);
		dbJPAConnector.createUser(driver);
		dbJPAConnector.createBus(bus);
		resp.sendRedirect("users");
	}

	private void createDispatcher(HttpServletResponse resp, String login, String pass, String name) throws IOException {
		dbJPAConnector.createUser(new User(login, pass, name));
		resp.sendRedirect("users");
	}
}
