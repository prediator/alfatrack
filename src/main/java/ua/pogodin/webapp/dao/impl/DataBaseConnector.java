/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.dao.impl;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppException;
import ua.pogodin.webapp.util.Properties;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author elias
 */
public class DataBaseConnector implements JdbcConnection {
	public static final String PROPNAME_DRIVER_CLASS_NAME = "database.driverClassName";
	public static final String PROPNAME_URL = "database.url";
	public static final String PROPNAME_USERNAME = "database.username";
	public static final String PROPNAME_PASSWORD = "database.password";

	static {
		String driverClassName = Properties.get(PROPNAME_DRIVER_CLASS_NAME);
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			throw new Error("jdbc driver" + driverClassName + " not found", e);
		}
	}

	@Override
	public boolean isDispatcher(String login) {
		DbExecutor executor = DbExecutor.execSelect("select isdispatcher from users where login=?", login);

		try {
			ResultSet rs = executor.rs();

			if (!rs.next()) {
				throw new AppException("No user with login " + login);
			}

			return rs.getBoolean("isdispatcher");
		} catch (SQLException e) {
			throw new AppException("Can't find user with login " + login);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public User getUserById(Long id) {
		DbExecutor executor = DbExecutor.execSelect("select * from users where id=?", Long.toString(id));
		try {
			if (!executor.rs().next()) {
				throw new AppException("No user with id " + id);
			}
			return getUserFromRs(executor.rs());
		} catch (SQLException e) {
			throw new AppException("Can't find user with id " + id);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public void deleteUserByLogin(String login) {
		DbExecutor.execUpdate("delete from users where login=?", login);
	}

	@Override
	public User getUserByLogin(String login) {
		DbExecutor executor = DbExecutor.execSelect("select * from users where login=?", login);
		try {
			if (!executor.rs().next()) {
				throw new AppException("No user with login " + login);
			}
			return getUserFromRs(executor.rs());
		} catch (SQLException e) {
			throw new AppException("Can't find user with login " + login);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public User getUserByLoginAndPass(String login, String password) {
		DbExecutor executor = DbExecutor
				.execSelect("select * from users where login=? and password=?", login, password);
		try {
			if (!executor.rs().next()) {
				throw new AppException("No user with login " + login + " and password " + password);
			}
			return getUserFromRs(executor.rs());
		} catch (SQLException e) {
			throw new AppException("Can't find user with login " + login + " and password " + password);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public User createUser(User user) {
		int intIsDispatcher = user.isIsDispatcher() ? 1 : 0;
		String busid = user.getBus() != null ? user.getBus().getId() != null ? Long.toString(user.getBus().getId())
				: null : null;
		DbExecutor.execUpdate("insert into users (login,password,isdispatcher,busid,name) values (?,?,?,?,?)",
				user.getLogin(), user.getPassword(), Integer.toString(intIsDispatcher), busid, user.getName());
		return getUserByLogin(user.getLogin());
	}

	@Override
	public boolean isLoginFree(String login) {
		DbExecutor executor = DbExecutor.execSelect("select count(id) from users where login=?", login);
		try {
			if (!executor.rs().next()) {
				throw new AppException("Can't count users by login");
			}
			return executor.rs().getInt(1) == 0;
		} catch (SQLException e) {
			throw new AppException("Can't count users by login", e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public int getUsersCount() {
		DbExecutor executor = DbExecutor.execSelect("select count(id) from users");
		try {
			if (!executor.rs().next()) {
				throw new AppException("Can't extract user count from DB");
			}
			return executor.rs().getInt(1);
		} catch (SQLException e) {
			throw new AppException("Can't extract users count from DB", e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public List<User> findAllUsers() {
		DbExecutor executor = DbExecutor.execSelect("select * from users");
		ResultSet rs = executor.rs();
		try {
			List<User> users = new ArrayList<User>();

			while (rs.next()) {
				users.add(getUserFromRs(rs));
			}
			return users;
		} catch (SQLException e) {
			throw new AppException("Can't extract users from DB", e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
    public Bus createBus(Bus bus) {
        DbExecutor.execUpdate("insert into busses (busload,maxspeed,workingorder) values (?,?,?)",
                Integer.toString(bus.getBusload()), Integer.toString(bus.getMaxSpeed()),
                bus.isWorkingOrder() ? "1" : "0");
        DbExecutor executor = DbExecutor.execSelect("select * from busses where id in(select max(id) from busses)");
        
        try {
            if (executor.rs().next()) {
            	bus.setId(executor.rs().getLong("id"));
            } else {
            	throw new AppException("Can't find bus just saved");
            }
            return getBusFromRs(executor.rs());
        } catch (SQLException e) {
            throw new AppException("Can't extract busses count from DB", e);
        } finally {
            DbExecutor.close(executor);
        }
    }

	@Override
	public Bus getBusById(Long id) {
		DbExecutor executor = DbExecutor.execSelect("select * from busses where id=?", Long.toString(id));
		try {
			ResultSet rs = executor.rs();

			if (!rs.next()) {
				throw new AppException("No bus with id " + id);
			}

			return getBusFromRs(rs);
		} catch (SQLException e) {
			throw new AppException("Can't find bus by id " + id, e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public Bus updateBusWorkingOrder(Long busId, boolean isWorking) {
		DbExecutor.execUpdate("update busses set workingorder=? where id=?", isWorking ? "1" : "0", busId.toString());
		return getBusById(busId);
	}

	@Override
	public BusApplication createBusApp(BusApplication busApp) {
		DbExecutor.execUpdate("insert into bus_application (minspeed,minbusload,isdone,userid) values (?,?,?,?)",
				Integer.toString(busApp.getMinSpeed()), Integer.toString(busApp.getMinBusLoad()),
				busApp.isIsdone() ? "1" : "0", Long.toString(busApp.getUserId()));
		DbExecutor executor = DbExecutor
				.execSelect("select * from bus_application where id in(select max(id) from bus_application)");

		try {
			if (!executor.rs().next()) {
				throw new AppException("Can't find bus application just saved");
			}
			return getBusAppFromRs(executor.rs());
		} catch (SQLException e) {
			throw new AppException("Can't extract bus applications count from DB", e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public List<BusApplication> findAllBusApplications() {
		DbExecutor executor = DbExecutor.execSelect("select * from bus_application");
		ResultSet rs = executor.rs();
		try {
			List<BusApplication> busApps = new ArrayList<BusApplication>();

			while (rs.next()) {
				busApps.add(getBusAppFromRs(rs));
			}
			return busApps;
		} catch (SQLException e) {
			throw new AppException("Can't extract users from DB", e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public List<BusApplication> findBusAppsByUserId(Long userId) {
		DbExecutor executor = DbExecutor.execSelect("select * from bus_application where userid=?", userId.toString());
		ResultSet rs = executor.rs();
		try {
			List<BusApplication> busApps = new ArrayList<BusApplication>();

			while (rs.next()) {
				busApps.add(getBusAppFromRs(rs));
			}
			return busApps;
		} catch (SQLException e) {
			throw new AppException("Can't extract users from DB", e);
		} finally {
			DbExecutor.close(executor);
		}
	}

	@Override
	public void setBusAppsDone(Long[] appIds) {
		String[] ids = new String[appIds.length];
		String placeHolders = "";

		for (int i = 0; i < appIds.length; i++) {
			ids[i] = appIds[i].toString();
			placeHolders += ",?";
		}

		placeHolders = placeHolders.substring(1);

		DbExecutor.execUpdate("update bus_application set isdone=1 where id in (" + placeHolders + ")", ids);
	}

	@Override
	public void updateBusAppsUsers(List<BusApplication> apps) {
		for (BusApplication app : apps) {
			DbExecutor.execUpdate("update bus_application set userid=? where id=?", app.getUserId().toString(), app
					.getId().toString());
		}
	}

	private User getUserFromRs(ResultSet rs) throws SQLException {
		boolean isDispatcher = rs.getBoolean("isdispatcher");
		Long id = rs.getLong("id");
		String login = rs.getString("login");
		String password = rs.getString("password");
		String name = rs.getString("name");
		Bus bus = isDispatcher ? new Bus() : getBusById(rs.getLong("busid"));

		User user = new User(login, password, name, isDispatcher, bus);
		user.setId(id);
		return user;
	}

	private Bus getBusFromRs(ResultSet rs) throws SQLException {
		Bus bus = new Bus(rs.getInt("busload"), rs.getInt("maxspeed"), rs.getBoolean("workingorder"));
		bus.setId(rs.getLong("id"));
		return bus;
	}

	private BusApplication getBusAppFromRs(ResultSet rs) throws SQLException {
		BusApplication busApp = new BusApplication(rs.getInt("minspeed"), rs.getInt("minbusload"),
				rs.getBoolean("isdone"), rs.getLong("userid"));
		busApp.setId(rs.getLong("id"));
		return busApp;
	}
}
