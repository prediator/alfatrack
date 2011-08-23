package ua.pogodin.webapp.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppException;

@Stateless
public class HiberJPADao extends BaseHiberDao implements DbConnection {

	@SuppressWarnings("unchecked")
	public List<User> getAllTrips(Bus bus) {
		try {
			begin();
			return getEm().createQuery("SELECT DISTINCT t FROM Trip t WHERE t.bus=?1").setParameter(1, bus)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public void createEntity(Object entity) {
		begin();
		persist(entity);
		commit();
		closeAll();
	}

	public void deleteEntity(Object obj) {
		begin();
		getEm().remove(getEm().merge(obj));
		commit();
		closeAll();
	}

	public void deleteListEnteties(List<Object> objs) {

		int j = 0;
		for (int i = 0; i < objs.size() && j < objs.size(); i++) {
			if (objs.get(i) instanceof Trip) {
				Collections.swap(objs, i, j);
				j++;
			}
		}
		for (int i = 0; i < objs.size() && j < objs.size(); i++) {
			if (objs.get(i) instanceof User) {
				Collections.swap(objs, i, j);
				j++;
			}
		}
		System.out.println(objs);
		for (Object object : objs) {
			deleteEntity(object);
		}
	}

	@Override
	public boolean isDispatcher(String login) {
		return false;
	}

	@Override
	public User getUserById(Long id) {
		begin();
		User user = getEm().find(User.class, id);
		closeAll();
		return user;
	}

	@Override
	public Trip getTripById(Long id) {
		begin();
		Trip trip = getEm().find(Trip.class, id);
		closeAll();
		return trip;
	}

	@Override
	public Driver getDriverById(Long id) {
		begin();
		Driver driver = getEm().find(Driver.class, id);
		closeAll();
		return driver;
	}

	@Override
	public void deleteUserByLogin(String login) {
		User deletedUser = getUserByLogin(login);
		begin();
		getEm().remove(getEm().merge(deletedUser));
		commit();
		closeAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByLogin(String login) {
		begin();
		List<User> users = getEm().createQuery("SELECT u FROM User u WHERE u.login LIKE ?1").setParameter(1, login)
				.getResultList();
		closeAll();
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Driver getDriverByLogin(String login) {
		begin();
		List<Driver> drivers = getEm().createQuery("SELECT u FROM Driver u WHERE u.login LIKE ?1")
				.setParameter(1, login).getResultList();
		closeAll();
		if (drivers != null && !drivers.isEmpty()) {
			return drivers.get(0);
		}
		return null;
	}

	@Override
	public User getUserByLoginAndPass(String login, String password) {
		User user = getUserByLogin(login);
		begin();
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			Driver driver = getDriverByLogin(login);
			if (driver != null && driver.getPassword().equals(password)) {
				return driver;
			}
		}
		closeAll();
		return null;
	}

	@Override
	public void createUser(User user) {
		try {
			if (isLoginFree(user.getLogin())) {
				begin();
				if (user.isDispatcher()) {
					persist(user);
				} else {
					Driver driver = (Driver) user;
					if (!driver.getBus().isBusReal()) {
						return;
					}
					if (driver.getBus() != null) {
						if (driver.getBus().getId() != null) {
							persist(driver);
						} else {
							commit();
							createBus(driver.getBus());
							begin();
							persist(driver);
						}

					}
				}
			}
		} finally {
			commit();
			closeAll();
		}
	}

	@Override
	public boolean isLoginFree(String login) {
		User user = getUserByLogin(login);
		if (user == null) {
			return true;
		}
		return false;
	}

	@Override
	public int getUsersCount() {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllDispatchers() throws AppException {
		begin();
		List<User> users = getEm().createQuery("SELECT u FROM User u").getResultList();
		closeAll();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> getAllDrivers() throws AppException {
		begin();
		List<Driver> drivers = getEm().createQuery("SELECT u FROM Driver u").getResultList();
		List<Driver> returned = new ArrayList<Driver>();
		returned.addAll(drivers);
		closeAll();
		return returned;
	}

	@Override
	public List<User> getAllUsers() throws AppException {
		begin();
		List<User> users = getEm().createQuery("SELECT u FROM User u").getResultList();
		users.addAll(getEm().createQuery("SELECT u FROM Driver u").getResultList());
		closeAll();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bus getBusById(Long id) {
		try {
			begin();
			Bus bus = getEm().find(Bus.class, id);
			return bus;
		} catch (java.lang.IllegalArgumentException e) {
			return null;
		} finally {
			closeAll();
		}
	}

	@Override
	public Bus getBusByDriverId(Long id) {
		Driver dr = getDriverById(id);
		return dr.getBus();

	}

	@Override
	public Driver getDriverByBusId(Long id) {
		Bus bus = getBusById(id);
		return bus.getDriver();

	}

	@Override
	public Bus createBus(Bus bus) {
		try {
			createEntity(bus);
			if (bus.getDriver() != null) {
				bus.getDriver().setBus(bus);
			}
			return bus;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void updateBusWorkingOrder(Bus bus, boolean isWorking) {
		begin();
		getEm().merge(bus);
		bus.setWorkingorder(isWorking);
		commit();
		closeAll();
	}

	@Override
	public BusApplication createBusApp(BusApplication busApplication) {
		createEntity(busApplication);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusApplication> findAllBusApplications() {
		begin();
		List<BusApplication> busapps = getEm().createQuery("SELECT ba FROM BusApplication ba").getResultList();
		closeAll();
		return busapps;
	}

	@Override
	public List<Trip> findTripsByDriverId(Long userId) {
		Driver dr = getDriverById(userId);
		Bus bus = getBusById(dr.getBus().getId());
		return bus.getTrips();
	}

	@Override
	public void setBusTripDone(Long[] ids) {
		for (Long id : ids) {
			Trip trip = getTripById(id);
			trip.setIsdone(true);
			begin();
			getEm().merge(trip);
		}
		commit();
		closeAll();
	}

	@Override
	public void deleteTrip(Trip trip) {
		begin();
		getEm().remove(getEm().merge(trip));
		getEm().getTransaction().commit();
		closeAll();
	}

	@Override
	public void deleteTrips(List<Trip> trips) {
		begin();
		for (Trip trip : trips) {
			getEm().remove(getEm().merge(trip));
		}
		getEm().getTransaction().commit();
		closeAll();
	}

	@Override
	public void createTrip(Trip trip) {
		createEntity(trip);
	}

	@Override
	public void createTrips(List<Trip> trips) {
		for (Trip trip : trips) {
			createTrip(trip);
		}
	}

	@Override
	public void updateTrips(List<Trip> trips) {

	}

	@Override
	public List<Driver> getDriversByAppId(Long id) {

		begin();
		List<Trip> trips = getEm().createQuery("SELECT t FROM Trip t WHERE t.busapp.id LIKE ?1").setParameter(1, id)
				.getResultList();
		List<Driver> drivers = new ArrayList<Driver>();
		for (Trip trip : trips) {
			drivers.add(getDriverByBusId(trip.getBus().getId()));
		}
		return drivers;
	}

	@SuppressWarnings("unchecked")
	public List<Trip> getAllTrips() {
		try {
			begin();
			return getEm().createQuery("SELECT t FROM Trip t").getResultList();
		} finally {
			closeAll();
		}
	}

	@Override
	public BusApplication getBusAppById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getUserByAppId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}