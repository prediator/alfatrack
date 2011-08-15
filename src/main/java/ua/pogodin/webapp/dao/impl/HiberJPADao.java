package ua.pogodin.webapp.dao.impl;

import java.util.List;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.Driver;
import ua.pogodin.webapp.domain.Trip;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppException;

public class HiberJPADao extends BaseHiberDao implements DbConnection {

	private BaseHiberDao bh = new BaseHiberDao();

	@SuppressWarnings("unchecked")
	public List<User> getAllTrips(Bus bus) {
		try {
			bh.begin();
			return bh.getEm().createQuery("SELECT DISTINCT t FROM Trip t WHERE t.bus=?1").setParameter(1, bus)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public void createEntity(Object entity) {
		bh.begin();
		bh.persist(entity);
		bh.commit();
		bh.closeAll();
	}

	@Override
	public boolean isDispatcher(String login) {

		return false;
	}

	@Override
	public User getUserById(Long id) {
		bh.begin();
		User user = bh.getEm().find(User.class, id);
		bh.closeAll();
		return user;
	}
	@Override
	public Trip getTripById(Long id){
		bh.begin();
		Trip trip = bh.getEm().find(Trip.class, id);
		bh.closeAll();
		return trip;
	}

	@Override
	public Driver getDriverById(Long id) {
		bh.begin();
		Driver driver = bh.getEm().find(Driver.class, id);
		bh.closeAll();
		return driver;
	}

	@Override
	public void deleteUserByLogin(String login) {
		User deletedUser = getUserByLogin(login);
		bh.begin();
		bh.getEm().remove(bh.getEm().merge(deletedUser));
		bh.commit();
		bh.closeAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByLogin(String login) {
		bh.begin();
		List<User> users = bh.getEm().createQuery("SELECT u FROM User u WHERE u.login LIKE ?1").setParameter(1, login)
				.getResultList();
		bh.closeAll();
		if (users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}
	@Override
	public Driver getDriverByLogin(String login) {
		bh.begin();
		List<Driver> drivers = bh.getEm().createQuery("SELECT u FROM Driver u WHERE u.login LIKE ?1").setParameter(1, login)
				.getResultList();
		bh.closeAll();
		if (drivers != null && !drivers.isEmpty()) {
			return drivers.get(0);
		}
		return null;
	}

	@Override
	public User getUserByLoginAndPass(String login, String password) {
		User user = getUserByLogin(login);
		bh.begin();
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}else{
			Driver driver = getDriverByLogin(login);
			if(driver != null && driver.getPassword().equals(password)){
				return driver;
			}
		}
		bh.closeAll();
		return null;
	}

	@Override
	public void createUser(User user) {
		try {
			if (isLoginFree(user.getLogin())) {
				bh.begin();
				if (user.isDispatcher()) {
					bh.persist(user);
				} else {
					bh.persist((Driver) user);
				}
			}
		} finally {
			bh.commit();
			bh.closeAll();
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
		bh.begin();
		List<User> users = bh.getEm().createQuery("SELECT u FROM User u").getResultList();
		bh.closeAll();
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Driver> getAllDrivers() throws AppException {
		bh.begin();
		List<Driver> users = bh.getEm().createQuery("SELECT u FROM Driver u").getResultList();
		bh.closeAll();
		return users;
	}
	
	@Override
	public List<User> getAllUsers() throws AppException {
		bh.begin();
		List<User> users = bh.getEm().createQuery("SELECT u FROM User u").getResultList();
		users.addAll(bh.getEm().createQuery("SELECT u FROM Driver u").getResultList());
		bh.closeAll();
		return users;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Bus getBusById(Long id) {
		bh.begin();
		Bus bus = bh.getEm().find(Bus.class, id);
		bh.closeAll();
		return bus;
	}

	@Override
	public Bus createBus(Bus bus) {
		try {
			createEntity(bus);
			return bus;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Bus updateBusWorkingOrder(Long busId, boolean isWorking) {
		Bus bus = getBusById(busId);
		bh.begin();
		bh.getEm().merge(bus);
		bus.setWorkingOrder(isWorking);
		bh.commit();
		bh.closeAll();
		return null;
	}

	@Override
	public BusApplication createBusApp(BusApplication busApplication) {
		createEntity(busApplication);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusApplication> findAllBusApplications() {
		bh.begin();
		List<BusApplication> busapps = bh.getEm().createQuery("SELECT ba FROM BusApplication ba").getResultList();
		bh.closeAll();
		return busapps;
	}

	@Override
	public List<Trip> findTripsByDriverId(Long userId) {
		Driver dr = getDriverById(userId);
		return dr.getBus().getTrips();
	}

	@Override
	public void setBusTripDone(Long[] ids) {
		bh.begin();
		for (Long id : ids) {
			Trip trip = getTripById(id);
			bh.getEm().merge(trip);
			trip.setIsdone(true);
			bh.getEm().getTransaction().commit();
		}
		bh.closeAll();
	}
}