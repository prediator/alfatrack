/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.dao.impl;

import java.sql.*;
import java.sql.DriverManager.*;
import java.util.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.domain.bus.Bus;

/**
 * 
 * @author elias
 */
public class DataBaseConnector implements JdbcConnection {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/autostation";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "letmeinit";

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	private static void createTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String createTableSQL = "CREATE TABLE DBUSER1(" + "USER_ID NUMBER(5) NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, " + "CREATED_BY VARCHAR(20) NOT NULL, "
				+ "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) " + ")";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(createTableSQL);

			System.out.println(createTableSQL);

			// execute create SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Table \"dbuser\" is created!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public void closeConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
		}
	}

	public boolean isDispatcher(String login) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {

		Connection conn = null;
		PreparedStatement ps = null;
		String sqlRequest = "SELECT * FROM users WHERE login='" + login + "'";

		try {

			conn = getDBConnection();
			ps = conn.prepareStatement(sqlRequest);
			ps.executeUpdate();

			rs = st.executeQuery(sqlRequest);
			rs.next();
			mark = rs.getInt("isdispatcher");
			if (mark == 1) {
				return true;
			}
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (ps != null) {
				ps.close();
			}

			if (conn != null) {
				conn.close();
			}

		}
	}

	public String getParam(String param, String login) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		String parametr = null;
		try {
			rs = st.executeQuery("Select *" + "from users where login='" + login + "'");
			rs.next();
			parametr = rs.getString(param);
		} catch (SQLException ex) {
		}
		return parametr;
	}

	public boolean isAccess(String login, String pass) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		try {
			rs = st.executeQuery("Select * from Users where password='" + pass + "'");
			rs.getMetaData().getColumnCount();
			rs.next();
			String log = rs.getString("login");
			if (log.equals(login)) {
				return true;
			}
		} catch (SQLException ex) {
		}
		return false;
	}

	public User getUserById(int id) throws SQLException {

		User user;
		rs = st.executeQuery("Select * From users Where id='" + id + "'");
		rs.next();
		boolean isDispatcher = rs.getBoolean("isdispatcher");
		user = new User(id, rs.getString("login"), rs.getString("password"), rs.getString("name"), isDispatcher,
				isDispatcher ? new Bus() : getBusById(rs.getInt("busid")));

		return user;
	}

	public void deleteUserByLogin(String login) throws SQLException {

		st.executeUpdate("Delete From users Where login='" + login + "'");
	}

	public User getUserByLogin(String login) throws SQLException {

		User user;
		rs = st.executeQuery("Select * From users Where login='" + login + "'");
		rs.next();
		boolean isDispatcher = rs.getBoolean("isdispatcher");
		user = new User(rs.getInt("id"), login, rs.getString("password"), rs.getString("name"), isDispatcher,
				isDispatcher ? new Bus() : getBusById(rs.getInt("busid")));

		return user;
	}

	public Bus getBusById(int id) throws SQLException {

		Bus bus;
		ResultSet rsLocal = conn.createStatement().executeQuery("Select * From busses Where id='" + id + "'");
		rsLocal.next();
		bus = new Bus(id, rsLocal.getInt("busload"), rsLocal.getInt("maxspeed"), rsLocal.getBoolean("workingorder"));

		return bus;
	}

	public void createUser(User user) throws SQLException {

		int intIsDispatcher = user.isDispatcher() ? 1 : 0;
		st.executeUpdate("Insert into users " + "(login,password,isdispatcher,busid,name) " + "values" + " ('"
				+ user.getLogin() + "', '" + user.getPassword() + "', " + intIsDispatcher + "," + user.getBus().getId()
				+ ",'" + user.getName() + "')");

	}

	public boolean isLoginFree(String login) throws SQLException {

		rs = st.executeQuery("Select count(id) from users where login='" + login + "'");
		rs.next();
		int res = rs.getInt(1);

		return (res > 0) ? false : true;
	}

	public int usersCount() throws SQLException {

		rs = st.executeQuery("Select count(id) from users");
		rs.next();
		return rs.getInt(1);
	}

	/*
	 * public void createUser(int id, String login) throws SQLException{
	 * st.executeUpdate("Insert into Users values("+id+",'"+login+
	 * "','pass','name','surname','address', 1233,0)"); }
	 */
	/*
	 * public static void main(String...args) throws ClassNotFoundException,
	 * InstantiationException, IllegalAccessException { try {
	 * Class.forName("com.mysql.jdbc.Driver").newInstance(); cn =
	 * DriverManager.getConnection(url, username, pass); if(cn!=null)
	 * System.out.println("Connection Successful !\n"); else{
	 * System.out.println("Can't connect to DB"); System.exit(1); } Statement
	 * st=cn.createStatement(); ResultSet
	 * rs=st.executeQuery("Select * from Users"); int
	 * x=rs.getMetaData().getColumnCount(); while(rs.next()){ for(int i=1;
	 * i<=x;i++){ System.out.print(rs.getString(i) + "\t"); } } st.close();
	 * rs.close(); cn.close(); } catch (SQLException ex) { } }
	 */
}
