package ua.pogodin.backingbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.dao.impl.DbUtil;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppsUtil;
import ua.pogodin.webapp.util.TripCreate;

@ManagedBean(name = "apps")
@RequestScoped
public class AppsView {

	private List<AppsUtil> apps;
	private List<TripCreate> trips;
	private User user;

	public AppsView() throws NamingException {
		DbConnection dbConn = (DbConnection) new InitialContext()
				.lookup("java:comp/env/AccountManagmentLocal");
		trips = new ArrayList<TripCreate>();
		
		for (BusApplication app : dbConn.findAllBusApplications()) {
			List<Driver> allDrivers = dbConn.getAllDrivers();
			List<Driver> otherDrivers = dbConn.getDriversByAppId(app.getId());
			List<Driver> needDrivers = AppsUtil.getOtherDrivers(otherDrivers, allDrivers);
			for (Driver driver : needDrivers) {
				trips.add(new TripCreate(app, driver));
			}
		}
		//HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		//user = (User)session.getAttribute("user");
	}

	public void setApps(List<AppsUtil> apps) {
		this.apps = apps;
	}

	public void setTrips(List<TripCreate> trips) {
		this.trips = trips;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TripCreate> getTrips() {
		return trips;
	}

	public List<AppsUtil> getApps() {
		return apps;
	}

	public String getHello() {
		return "hello";
	}

	public User getUser() {
		return user;
	}
	
	public void doSome() throws NamingException, IOException{
		DbConnection dbConn = (DbConnection) new InitialContext()
		.lookup("java:comp/env/AccountManagmentLocal");
		
		 HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
		for (TripCreate trip : trips) {
			if(trip.isNeedToCreate()){
				dbConn.createTrip(new Trip(trip.getDriver().getBus(), trip.getApp(), false));
			}
		}
		response.sendRedirect("trips");
		return;
	}
	
}
