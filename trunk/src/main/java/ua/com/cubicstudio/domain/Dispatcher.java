package ua.com.cubicstudio.domain;

import javax.persistence.Entity;

@Entity
public class Dispatcher extends User {
	public Dispatcher(String fullName, String login, String password) {
		super(fullName, login, password);
		isDispatcher = true;
	}

}
