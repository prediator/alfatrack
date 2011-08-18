package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Trip;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Driver extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(((User)req.getSession().getAttribute("user")).isDispatcher()){
			resp.sendRedirect("dispatcher");
		}
        changeWorkingOrderIfNeeded(req);
        List<Trip> trips = dbJPAConnector.findTripsByDriverId(getUser(req).getId());
        req.setAttribute("trips", trips);
        forward("/WEB-INF/jsp/driver.jsp", req, resp);
	}

    private void changeWorkingOrderIfNeeded(HttpServletRequest req) {
        String workingOrder = req.getParameter("workingorder");
        if (workingOrder != null) {
            boolean isBusWorking = Integer.valueOf(workingOrder) == 1;
            ua.pogodin.webapp.domain.Driver driver = (ua.pogodin.webapp.domain.Driver) getUser(req);
            dbJPAConnector.updateBusWorkingOrder(driver.getBus(), isBusWorking);
        }
    }

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] appIdArray = req.getParameterValues("dotrip");
        if (appIdArray != null) {
        	dbJPAConnector.setBusTripDone(convertToLongArr(appIdArray));
        }
        resp.sendRedirect("driver");
	}

    private Long[] convertToLongArr(String[] stringArr) {
        Long[] longArr = new Long[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            longArr[i] = Long.valueOf(stringArr[i]);
        }
        return longArr;
    }
}
