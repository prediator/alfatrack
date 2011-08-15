package ua.pogodin.webapp.dao;

import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppException;

import java.util.List;

public interface DbConnection {
    boolean isDispatcher(String login);

    User getUserById(Long id);
    
    Driver getDriverById(Long id);

    void deleteUserByLogin(String login);

    User getUserByLogin(String login);

    User getUserByLoginAndPass(String login, String password);

    void createUser(User user);

    boolean isLoginFree(String login);

    int getUsersCount();

    List<User> getAllDispatchers() throws AppException;
    
    List<Driver> getAllDrivers() throws AppException;

    Bus getBusById(Long id);

    Bus createBus(Bus bus);

    Bus updateBusWorkingOrder(Long busId, boolean isWorking);

    BusApplication createBusApp(BusApplication busApplication);

    List<BusApplication> findAllBusApplications();

    List<Trip> findTripsByDriverId(Long userId);

	Driver getDriverByLogin(String login);

	List<User> getAllUsers() throws AppException;

	void setBusTripDone(Long[] convertToLongArr);

	Trip getTripById(Long id);
}
