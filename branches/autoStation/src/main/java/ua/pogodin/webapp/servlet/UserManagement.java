package ua.pogodin.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.pogodin.webapp.domain.User;

public class UserManagement extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!((User)req.getSession().getAttribute("user")).isDispatcher()){
			resp.sendRedirect("driver");
		}
		
		req.setAttribute("disps", dbJPAConnector.getAllDispatchers());
		req.setAttribute("drivers", dbJPAConnector.getAllDrivers());
		forward("/WEB-INF/jsp/userManagement.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
