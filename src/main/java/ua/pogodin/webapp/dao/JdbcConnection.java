package ua.pogodin.webapp.dao;

import java.util.List;

import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.domain.bus.Bus;

public interface JdbcConnection {
	public boolean isDispatcher(String login);
	public String getParam(String param, String login);
	public boolean isAccess(String login, String pass) ;
	public User getUserById(int id);
	public void deleteUserByLogin(String login);
	public User getUserByLogin(String login) ;
	public Bus getBusById(int id) ;
	public void createUser(User user) ;
	public boolean isLoginFree(String login);
	public int usersCount() ;
	public List<User>getAllUsers();

}
