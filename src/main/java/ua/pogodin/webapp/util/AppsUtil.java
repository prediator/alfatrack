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

	private void setDriversOnOff(List<Driver> allDrivers) {
		if (driversOff.isEmpty()) {
			driversOff.addAll(allDrivers);
			driversOff.removeAll(driversOn);
			driversOff = Collections.synchronizedList(driversOff);
			for (int i = 0; i < driversOff.size(); i++) {
				if (!driversOff.get(i).getBus().isWorkingorder()) {
					driversOff.remove(driversOff.get(i));
				}
			}
		} else {

		}
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

	public void setDriversOn(List<Driver> driversOn, List<Driver> allDrivers) {
		this.driversOn.addAll(driversOn);
		setDriversOnOff(allDrivers);
	}

	public List<Driver> getDriversOff() {
		return driversOff;
	}

	public void setDriversOff(List<Driver> driversOff) {
		this.driversOff = driversOff;
	}

}
