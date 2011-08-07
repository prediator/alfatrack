package ua.pogodin.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.User;

public class BusCreate extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward("/WEB-INF/jsp/register.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int busload = Integer.valueOf((String)req.getAttribute("busload")).intValue();
		int maxSpeed = Integer.valueOf((String)req.getAttribute("maxSpeed")).intValue();


		if (busload == 0 || maxSpeed == 0) {
			
			//TODO: add ifs in busCreate.jsp
			req.setAttribute("busload", busload);
			req.setAttribute("maxSpeed", maxSpeed);
			forward("/WEB-INF/jsp/register.jsp", req, resp);
		} else {
			req.setAttribute("busload", busload);
			req.setAttribute("maxSpeed", maxSpeed);
			addBus(req, resp, busload, maxSpeed);
		}

	}

	protected void addBus(HttpServletRequest req, HttpServletResponse resp, int busload, int maxSpeed)
			throws IOException {

		User newUser = (User)req.getSession().getAttribute("addedUser");
		String isWorkingOrder = (String)req.getAttribute("isWorkingOrder");
		boolean doesntWork = isWorkingOrder == null || !isWorkingOrder.equals("true");
		Bus bus = new Bus(busload, maxSpeed, !doesntWork);

		
		//TODO: add bus mark
		//TODO: add adding bus and adding user
		dbConnector.createBus(bus);


	}
}
