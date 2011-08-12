/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author elias
 */

@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING,length=20) 
@DiscriminatorValue("dispatcher")
public class User {

	
	//TODO: add Oneto One, ManyToMany etc.
	//TODO: add fields to Trip
	//TODO: add DAO
	//TODO: run with hiber+jetty (ask about glassfish+maven)
	@Id
	@GeneratedValue
	private Long id;

	private String login;
	private String password;
	private String name;

	public User(String login, String password, String name) {
		this.login = login;
		this.password = password;
		this.name = name;
	}

	public User() {
		this.login = "";
		this.password = "";
		this.name = "";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" + "login=" + login + ", password=" + password + ", name=" + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
			return false;
		}
		if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
			return false;
		}
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 83 * hash + (this.login != null ? this.login.hashCode() : 0);
		hash = 83 * hash + (this.password != null ? this.password.hashCode() : 0);
		hash = 83 * hash + (this.name != null ? this.name.hashCode() : 0);
		return hash;
	}
}
