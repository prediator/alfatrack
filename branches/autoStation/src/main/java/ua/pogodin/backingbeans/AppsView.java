package ua.pogodin.backingbeans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.BusApplication;

@ManagedBean(name = "apps")
@ApplicationScoped
public class AppsView {

	private List<BusApplication> apps;

	public AppsView() throws NamingException {

		DbConnection dbConn = (DbConnection) new InitialContext()
				.lookup("autostation");
		apps = dbConn.findAllBusApplications();

	}

	public List<BusApplication> getApps() {
		return apps;
	}

	public String getHello() {
		return "hello";
	}
}
