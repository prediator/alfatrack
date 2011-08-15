package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!((User)req.getSession().getAttribute("user")).isDispatcher()){
			resp.sendRedirect("driver");
		}
		List<BusApplication> apps = dbJPAConnector.findAllBusApplications();
		List<User> users = dbJPAConnector.getAllUsers();
		List<User> needDrivers = new ArrayList<User>();
		
		req.setAttribute("apps", apps);
		req.setAttribute("users", needDrivers);
		forward("/WEB-INF/jsp/dispatcher.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BusApplication> apps = dbJPAConnector.findAllBusApplications();

		for (BusApplication app : apps) {
			if (!app.isIsdone()) {
				String parameter = req.getParameter(app.getId().toString());
				Long userId = Long.valueOf(parameter);
				app.setUserId(userId);
			}
		}

		dbJPAConnector.updateBusAppsUsers(apps);
		resp.sendRedirect("dispatcher");
	}
}
