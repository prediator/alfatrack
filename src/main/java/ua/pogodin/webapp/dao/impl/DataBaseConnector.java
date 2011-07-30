/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.dao.impl;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.domain.Bus;
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

    public User getUserById(int id) {
        DbExecutor executor = DbExecutor.execSelect("select * from users where id=?", Integer.toString(id));
        try {
            ResultSet rs = executor.rs();

            if (!rs.next()) {
                throw new AppException("No user with id " + id);
            }

            boolean isDispatcher = rs.getBoolean("isdispatcher");
            return new User(id, rs.getString("login"), rs.getString("password"), rs.getString("name"), isDispatcher,
                    isDispatcher ? new Bus() : getBusById(rs.getInt("busid")));
        } catch (SQLException e) {
            throw new AppException("Can't find user with id " + id);
        } finally {
            DbExecutor.close(executor);
        }
    }

    public void deleteUserByLogin(String login) {
        DbExecutor.execUpdate("delete from users where login=?", login);
    }

    public User getUserByLogin(String login) {
        DbExecutor executor = DbExecutor.execSelect("Select * From users Where login=?", login);
        try {
            ResultSet rs = executor.rs();

            if (!rs.next()) {
                throw new AppException("No user with login " + login);
            }

            boolean isDispatcher = rs.getBoolean("isdispatcher");
            return new User(rs.getInt("id"), login, rs.getString("password"), rs.getString("name"), isDispatcher,
                    isDispatcher ? new Bus() : getBusById(rs.getInt("busid")));
        } catch (SQLException e) {
            throw new AppException("Can't find user with login " + login);
        } finally {
            DbExecutor.close(executor);
        }
    }

    public Bus getBusById(int id) {
        DbExecutor executor = DbExecutor.execSelect("select * from busses where id=?", Integer.toString(id));
        try {
            ResultSet rs = executor.rs();

            if (!rs.next()) {
                throw new AppException("No bus with id " + id);
            }

            return new Bus(id, rs.getInt("busload"), rs.getInt("maxspeed"), rs.getBoolean("workingorder"));
        } catch (SQLException e) {
            throw new AppException("Can't find bus by id " + id, e);
        } finally {
            DbExecutor.close(executor);
        }
    }

    public void createUser(User user) {
        int intIsDispatcher = user.isDispatcher() ? 1 : 0;
        DbExecutor.execUpdate("Insert into users (login,password,isdispatcher,busid,name) values (?,?,?,?,?)",
                user.getLogin(), user.getPassword(), Integer.toString(intIsDispatcher),
                Integer.toString(user.getBus().getId()), user.getName());
    }

    public boolean isLoginFree(String login) {
        DbExecutor executor = DbExecutor.execSelect("Select count(id) from users where login=?", login);
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

    public int getUsersCount() {
        DbExecutor executor = DbExecutor.execSelect("Select count(id) from users");
        try {
            if (!executor.rs().next()) {
                throw new AppException("Can't extract user count from DB");
            }
            return executor.rs().getInt(1);
        } catch (SQLException e) {
            throw new AppException("Can't extract user count from DB", e);
        } finally {
            DbExecutor.close(executor);
        }
    }

    public List<User> findAllUsers() {
        DbExecutor executor = DbExecutor.execSelect("Select * from users");
        try {
            List<User> users = new ArrayList<User>();
            
            while (executor.rs().next()) {
                boolean isDispatcher = executor.rs().getBoolean("isdispatcher");
                int id = executor.rs().getInt("id");
                String login = executor.rs().getString("login");
                String password = executor.rs().getString("password");
                String name = executor.rs().getString("name");
                Bus bus = isDispatcher ? new Bus() : getBusById(executor.rs().getInt("busid"));

                users.add(new User(id, login, password, name, isDispatcher, bus));
            }
            return users;
        } catch (SQLException e) {
            throw new AppException("Can't extract users from DB", e);
        } finally {
            DbExecutor.close(executor);
        }
    }
}
