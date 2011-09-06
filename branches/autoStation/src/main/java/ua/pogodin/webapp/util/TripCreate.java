package ua.pogodin.webapp.util;

import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;

public class TripCreate {

	BusApplication app ;
	Driver driver;
	boolean needToCreate;
	boolean created = false;
	
	public TripCreate(BusApplication app, Driver driver) {
		this.app = app;
		this.driver = driver;
		this.needToCreate = false;
	}

	public BusApplication getApp() {
		return app;
	}

	public void setApp(BusApplication app) {
		this.app = app;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public boolean isNeedToCreate() {
		return needToCreate;
	}

	public void setNeedToCreate(boolean needToCreate) {
		this.needToCreate = needToCreate;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}
	
	
}
