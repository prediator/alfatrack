package ua.pogodin.backingbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppsUtil;

@ManagedBean(name = "apps")
@ApplicationScoped
public class AppsView {

	private List<AppsUtil> apps;
	private User user;

	public AppsView() throws NamingException {
		DbConnection dbConn = (DbConnection) new InitialContext()
				.lookup("java:comp/env/AccountManagmentLocal");
		apps = new ArrayList<AppsUtil>();
		
		List<Driver> allDrivers = dbConn.getAllDrivers();
		for (BusApplication app : dbConn.findAllBusApplications()) {
			apps.add(new AppsUtil(app));
			apps.get(apps.size() - 1).setDriversOn(dbConn.getDriversByAppId(app.getId()),allDrivers);
		}
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		user = (User)session.getAttribute("user");
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
	
}
