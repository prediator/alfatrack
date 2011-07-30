/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.domain;

/**
 *
 * @author elias
 */
public class User {
    
    private int id;
    private String login;
    private String password;
    private String name;
    private boolean isDispatcher;
    private Bus bus;
    
    public User(int id,String login, String password, String name,
            boolean isDispatcher, Bus bus) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.isDispatcher = isDispatcher;
        this.bus = bus;
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean isDispatcher() {
        return isDispatcher;
    }
    
     public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setIsDispatcher(boolean isDispatcher) {
        this.isDispatcher = isDispatcher;
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
        return "User{" + "login=" + login + ", password=" + password + ", name=" + name + ", isDispatcher=" + isDispatcher + ", bus=" + bus + '}';
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
