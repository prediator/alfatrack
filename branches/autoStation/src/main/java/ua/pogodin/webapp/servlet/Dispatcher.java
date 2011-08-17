package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;
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
		List<List<Driver>> appListDrivers = new ArrayList<List<Driver>>();
		for (BusApplication app : apps) {
			List<Driver> allDrivers = dbJPAConnector.getAllDrivers();
			List<Driver> drivers = dbJPAConnector.getDriversByAppId(app.getId());
			allDrivers.removeAll(drivers);
			for (Driver driver : allDrivers) {
				if(!driver.getBus().isWorkingOrder()){
					allDrivers.remove(driver);
				}
			}
			appListDrivers.add(allDrivers);
		}
		req.setAttribute("apps", apps);
		req.setAttribute("applist", appListDrivers);
		forward("/WEB-INF/jsp/dispatcher.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BusApplication> apps = dbJPAConnector.findAllBusApplications();

		for (BusApplication app : apps) {
				String parameter = req.getParameter(app.getId().toString());
				Long userId = Long.valueOf(parameter);
				if(userId > 0){
					System.out.println(parameter);
					Bus bus = dbJPAConnector.getBusByDriverId(userId);
					if(bus != null){
						dbJPAConnector.createTrip(new Trip(bus,app, false));
					}
				}
				
		}
		resp.sendRedirect("dispatcher");
	}
}
