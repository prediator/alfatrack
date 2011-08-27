package ua.pogodin.webapp.dao.impl;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.*;
import ua.pogodin.webapp.util.AppException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class DbUtil implements DbConnection {

	@PersistenceContext(unitName = "autostation" )
	public EntityManager em;

	@SuppressWarnings("unchecked")
	public List<User> getAllTrips(Bus bus) {
		try {
			return em
					.createQuery("SELECT DISTINCT t FROM Trip t WHERE t.bus=?1")
					.setParameter(1, bus).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public void createEntity(Object entity) {
		em.persist(entity);
	}

	public void deleteEntity(Object obj) {
		em.remove(em.merge(obj));
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

		User user = em.find(User.class, id);

		return user;
	}

	@Override
	public Trip getTripById(Long id) {

		Trip trip = em.find(Trip.class, id);

		return trip;
	}

	@Override
	public Driver getDriverById(Long id) {

		Driver driver = em.find(Driver.class, id);

		return driver;
	}

	@Override
	public void deleteUserByLogin(String login) {
		User deletedUser = getUserByLogin(login);
		em.remove(em.merge(deletedUser));
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByLogin(String login) {

		List<User> users = em
				.createQuery("SELECT u FROM User u WHERE u.login LIKE ?1")
				.setParameter(1, login).getResultList();

		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Driver getDriverByLogin(String login) {

		List<Driver> drivers = em
				.createQuery("SELECT u FROM Driver u WHERE u.login LIKE ?1")
				.setParameter(1, login).getResultList();

		if (drivers != null && !drivers.isEmpty()) {
			return drivers.get(0);
		}
		return null;
	}

	@Override
	public User getUserByLoginAndPass(String login, String password) {
		User user = getUserByLogin(login);

		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			Driver driver = getDriverByLogin(login);
			if (driver != null && driver.getPassword().equals(password)) {
				return driver;
			}
		}

		return null;
	}

	@Override
	public void createUser(User user) {
		try {
			if (isLoginFree(user.getLogin())) {

				if (user.isDispatcher()) {
					em.persist(user);
				} else {
					Driver driver = (Driver) user;
					if (!driver.getBus().isBusReal()) {
						return;
					}
					if (driver.getBus() != null) {
						if (driver.getBus().getId() != null) {
							em.persist(driver);
						} else {
							createBus(driver.getBus());
							em.persist(driver);
						}

					}
				}
			}
		} catch (Exception e) {
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

		List<User> users = em.createQuery("SELECT u FROM User u")
				.getResultList();

		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> getAllDrivers() throws AppException {

		List<Driver> drivers = em.createQuery("SELECT u FROM Driver u")
				.getResultList();
		List<Driver> returned = new ArrayList<Driver>();
		returned.addAll(drivers);

		return returned;
	}

	@Override
	public List<User> getAllUsers() throws AppException {

		List<User> users = em.createQuery("SELECT u FROM User u")
				.getResultList();
		users.addAll(em.createQuery("SELECT u FROM Driver u").getResultList());

		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bus getBusById(Long id) {
		try {

			Bus bus = em.find(Bus.class, id);
			return bus;
		} catch (java.lang.IllegalArgumentException e) {
			return null;
		} finally {

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

		em.merge(bus);
		bus.setWorkingorder(isWorking);

	}

	@Override
	public BusApplication createBusApp(BusApplication busApplication) {
		createEntity(busApplication);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusApplication> findAllBusApplications() {

		List<BusApplication> busapps = em.createQuery(
				"SELECT ba FROM BusApplication ba").getResultList();

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

			em.merge(trip);
		}

	}

	@Override
	public void deleteTrip(Trip trip) {

		em.remove(em.merge(trip));
		em.getTransaction().commit();

	}

	@Override
	public void deleteTrips(List<Trip> trips) {

		for (Trip trip : trips) {
			em.remove(em.merge(trip));
		}
		em.getTransaction().commit();

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

		List<Trip> trips = em
				.createQuery("SELECT t FROM Trip t WHERE t.busapp.id LIKE ?1")
				.setParameter(1, id).getResultList();
		List<Driver> drivers = new ArrayList<Driver>();
		for (Trip trip : trips) {
			drivers.add(getDriverByBusId(trip.getBus().getId()));
		}
		return drivers;
	}

	@SuppressWarnings("unchecked")
	public List<Trip> getAllTrips() {
		try {

			return em.createQuery("SELECT t FROM Trip t").getResultList();
		} finally {
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