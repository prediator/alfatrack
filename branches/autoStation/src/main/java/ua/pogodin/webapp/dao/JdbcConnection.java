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

    User getUserByLoginAndPass(String login, String password);

    User createUser(User user);

    boolean isLoginFree(String login);

    int getUsersCount();

    List<User> findAllUsers() throws AppException;

    Bus getBusById(Long id);

    Bus createBus(Bus bus);

    Bus updateBusWorkingOrder(Long busId, boolean isWorking);

    BusApplication createBusApp(BusApplication busApplication);

    List<BusApplication> findAllBusApplications();

    List<BusApplication> findBusAppsByUserId(Long userId);
}
