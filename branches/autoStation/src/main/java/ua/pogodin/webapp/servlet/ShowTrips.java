package ua.pogodin.webapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.pogodin.webapp.domain.Trip;

public class ShowTrips extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Trip> trips = dbJPAConnector.getAllTrips();
		req.setAttribute("trips", trips);
		forward("/WEB-INF/jsp/allTrips.jsp", req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
