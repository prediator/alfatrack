package ua.pogodin.webapp.dao;

import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.domain.bus.Bus;
import ua.pogodin.webapp.util.AppException;

import java.util.List;

public interface JdbcConnection {
    public boolean isDispatcher(String login);

    public User getUserById(int id);

    public void deleteUserByLogin(String login);

    public User getUserByLogin(String login);

    public Bus getBusById(int id);

    public void createUser(User user);

    public boolean isLoginFree(String login);

    public int getUsersCount();

    public List<User> findAllUsers() throws AppException;

}
