package ua.com.cubicstudio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public abstract class User {
	@Id
	@GeneratedValue
	private Long id;

	private String fullName;
	private String login;
	private String password;
	protected boolean isDispatcher;

	public User() {
	}

	public User(String fullName, String login, String password) {
		this.fullName = fullName;
		this.login = login;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public boolean getIsDispatcher() {
		return isDispatcher;
	}

	public void setIsDispatcher(boolean isDispatcher) {
		this.isDispatcher = isDispatcher;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[" + id + "] " + fullName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		User user = (User) o;

		return id != null && id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
