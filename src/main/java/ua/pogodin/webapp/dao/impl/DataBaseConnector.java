/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.dao.impl;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.domain.bus.Bus;
import ua.pogodin.webapp.util.Properties;

import java.sql.*;

/**
 * 
 * @author elias
 */
public class DataBaseConnector implements JdbcConnection {
    public static final String PROPNAME_DRIVER_CLASS_NAME = "database.driverClassName";
    public static final String PROPNAME_URL = "database.url";
    public static final String PROPNAME_USERNAME = "database.username";
    public static final String PROPNAME_PASSWORD = "database.password";

    private Connection mainConn = null;
	private PreparedStatement mainPs = null;

	public DataBaseConnector() {

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

            Class.forName(Properties.get(PROPNAME_DRIVER_CLASS_NAME));

        } catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(Properties.get(PROPNAME_URL),
                    Properties.get(PROPNAME_USERNAME), Properties.get(PROPNAME_PASSWORD));
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	private void printErrMessage(SQLException e) {

	}

	private void setDBUpdate(String sqlRequest) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		conn = getDBConnection();
		ps = conn.prepareStatement(sqlRequest);
		mainConn = conn;
		mainPs = ps;
		ps.executeUpdate();

		if (ps != null) {
			ps.close();
		}

		if (conn != null) {

			conn.close();
		}

	}

	private ResultSet getResultSet(String sqlRequest) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = getDBConnection();
			ps = conn.prepareStatement(sqlRequest);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			printErrMessage(e);
		}
		return rs;
	}

	private void closeConnections() throws SQLException {
		if (mainPs != null) {
			mainPs.close();
		}
		if (mainConn != null) {
			mainConn.close();
		}
	}

	public boolean isDispatcher(String login) {

		ResultSet rs = null;
		String sqlRequest = "SELECT * FROM users WHERE login='" + login + "'";

		try {

			rs = getResultSet(sqlRequest);
			rs.next();
			return (rs.getInt("isdispatcher") == 1);

		} catch (SQLException e) {

			printErrMessage(e);
		} finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}

		return false;
	}

	public String getParam(String param, String login) {
		String sqlRequest = "Select *" + "from users where login='" + login + "'";
		ResultSet rs = null;
		String parametr = "";

		try {
			rs = getResultSet(sqlRequest);
			rs.next();
			parametr = rs.getString(param);
		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return parametr;
	}

	public boolean isAccess(String login, String pass) {

		String sqlRequest = "Select * from Users where login='" + login + "'";
		ResultSet rs = null;
		String log = "";
		try {
			rs = getResultSet(sqlRequest);
			rs.next();
			log = rs.getString("login");
			return log.equals(login);

		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return false;
	}

	public User getUserById(int id) {

		User user;
		ResultSet rs = null;
		try {
			String sqlRequest = "Select * From users Where id='" + id + "'";
			rs = getResultSet(sqlRequest);
			rs.next();

			boolean isDispatcher = rs.getBoolean("isdispatcher");
			user = new User(id, rs.getString("login"), rs.getString("password"), rs.getString("name"), isDispatcher,
					isDispatcher ? new Bus() : getBusById(rs.getInt("busid")));

			return user;
		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return null;
	}

	public void deleteUserByLogin(String login) {

		try {
			setDBUpdate("Delete From users Where login='" + login + "'");
		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
	}

	public User getUserByLogin(String login) {

		User user;
		ResultSet rs = null;
		try {
			String sqlRequest = "Select * From users Where login='" + login + "'";
			rs = getResultSet(sqlRequest);
			rs.next();

			boolean isDispatcher = rs.getBoolean("isdispatcher");
			user = new User(rs.getInt("id"), login, rs.getString("password"), rs.getString("name"), isDispatcher,
					isDispatcher ? new Bus() : getBusById(rs.getInt("busid")));

			return user;
		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return null;
	}

	public Bus getBusById(int id) {

		Bus bus;
		ResultSet rs = null;
		try {
			String sqlRequest = "Select * From busses Where id='" + id + "'";
			rs = getResultSet(sqlRequest);
			rs.next();
			bus = new Bus(id, rs.getInt("busload"), rs.getInt("maxspeed"), rs.getBoolean("workingorder"));
			return bus;
		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return null;
	}

	public void createUser(User user) {
		// if isDispatcher - than 1 - else 0
		int intIsDispatcher = user.isDispatcher() ? 1 : 0;
		try {
			setDBUpdate("Insert into users " + "(login,password,isdispatcher,busid,name) " + "values" + " ('"
					+ user.getLogin() + "', '" + user.getPassword() + "', " + intIsDispatcher + ","
					+ user.getBus().getId() + ",'" + user.getName() + "')");
		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
	}

	public boolean isLoginFree(String login) {

		ResultSet rs = null;
		String sqlRequest = "Select count(id) from users where login='" + login + "'";
		try {
			rs = getResultSet(sqlRequest);
			rs.next();
			// getting first element from request
			return (rs.getInt(1) == 0);

		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return false;
	}

	public int usersCount() {

		ResultSet rs = null;
		String sqlRequest = "Select count(id) from users";
		try {
			rs = getResultSet(sqlRequest);
			rs.next();
			// getting first element from request
			return rs.getInt(1);

		} catch (SQLException e) {
			printErrMessage(e);
		}finally {
			try {
				closeConnections();
			} catch (SQLException e) {
				printErrMessage(e);
			}
		}
		return 0;
	}

}
