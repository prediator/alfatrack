package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Driver extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String workingOrder = req.getParameter("workingOrder");
        if (workingOrder != null) {
            boolean isBusWorking = Integer.valueOf(workingOrder) == 1;
            User user = getUser(req);
            user.getBus().setWorkingOrder(isBusWorking);
            Bus bus = dbConnector.updateBusWorkingOrder(user.getBus().getId(), isBusWorking);
            user.setBus(bus);
        }

        List<BusApplication> apps = dbConnector.findBusAppsByUserId(getUser(req).getId());
        req.setAttribute("apps", apps);
        forward("/WEB-INF/jsp/driver.jsp", req, resp);
	}

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("doapp");
//        List<BusApplication> apps = conn.findAllBusApplications();
//		resultRequest(user,apps,req,resp);
	}
}
