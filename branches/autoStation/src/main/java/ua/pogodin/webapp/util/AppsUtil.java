package ua.pogodin.webapp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;

public class AppsUtil {

	private BusApplication app;
	private List<Driver> driversOn;
	private List<Driver> driversOff;

	public AppsUtil(BusApplication app) {
		this.app = app;
		driversOn = new ArrayList<Driver>();
		driversOff = new ArrayList<Driver>();
	}


	
	public BusApplication getApp() {
		return app;
	}

	public void setApp(BusApplication app) {
		this.app = app;
	}

	public List<Driver> getDriversOn() {
		return driversOn;
	}

	public void setDriversOn(List<Driver> driversOn) {
		this.driversOn = driversOn;
	}


	public void setDriversOff(List<Driver> driversOff) {
		this.driversOff = driversOff;
	}

	public static List<Driver> getOtherDrivers(List<Driver> driversInp,
			List<Driver> allDrivers) {
		List<Driver> driversOut = new ArrayList<Driver>();
		driversOut.addAll(allDrivers);
		driversOut.removeAll(driversInp);
		driversOut = Collections.synchronizedList(driversOut);
		for (int i = 0; i < driversOut.size(); i++) {
			if (!driversOut.get(i).getBus().isWorkingorder()) {
				driversOut.remove(driversInp.get(i));
			}
		}
		return driversOut;
	}

}

