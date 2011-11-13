package ua.com.cubicstudio.domain;

import javax.persistence.Entity;

@Entity
public class Driver extends User {

	private String bus;
	private boolean isBusWoring;
	
	public Driver() {
		super();
	}

	public Driver(String fullName, String login, String password) {
		super(fullName, login, password);
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public boolean isBusWoring() {
		return isBusWoring;
	}

	public void setBusWoring(boolean isBusWoring) {
		this.isBusWoring = isBusWoring;
	}

}
