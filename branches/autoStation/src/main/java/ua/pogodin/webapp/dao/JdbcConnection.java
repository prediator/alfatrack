package ua.pogodin.webapp.dao;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppException;

import java.util.List;

public interface JdbcConnection {
    boolean isDispatcher(String login);
    User getUserById(Long id);
    void deleteUserByLogin(String login);
    User getUserByLogin(String login);
    Bus getBusById(Long id);
    User createUser(User user);
    boolean isLoginFree(String login);
    int getUsersCount();
    List<User> findAllUsers() throws AppException;
    Bus createBus(Bus bus);
    BusApplication createBusApp(BusApplication busApplication);
    List<BusApplication> findAllBusApplications();
}
