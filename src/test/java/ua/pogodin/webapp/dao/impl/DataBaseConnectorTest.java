package ua.pogodin.webapp.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.domain.bus.Bus;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author elias
 */
public class DataBaseConnectorTest {
    private JdbcConnection conn;

    @Before
    public void setUp() throws Exception {
        conn = new DataBaseConnector();
    }

    @Test
    public void testIsDispatcher() {
        boolean actual = conn.isDispatcher("admin");
        assertEquals(true, actual);
    }

    @Test
    public void testGetUserById() {
        User actual = conn.getUserById(1);
        User expected = new User(1, "admin", "admin", "kolya", true, new Bus());
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateThanDeleteUser() {
        String login = "login_test";
        conn.createUser(new User(3, login, login, login, true, new Bus()));
        conn.deleteUserByLogin(login);
        boolean actual = conn.isLoginFree(login);
        assertEquals(true, actual);
    }

    @Test
    public void testGetUserByLogin() {
        String login = "admin";
        User actual = conn.getUserByLogin(login);
        User expected = new User(1, login, login, "kolya", true, new Bus());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBusById() {
        Bus actual = conn.getBusById(1);
        Bus expected = new Bus(1, 45, 100, true);
        assertEquals(expected, actual);
    }

    @Test
    public void CreateUserInputIntoBaseThanGetBack() {
        String login = "tested_login";
        User user = new User(4, login, login, login, true, new Bus());
        conn.createUser(user);
        User actual = conn.getUserByLogin(login);
        assertEquals(user, actual);
    }

    @Test
    public void testIsLoginFree() {
        String freeLogin = "adminen";
        String takenLogin = "admin";
        assertEquals(true, conn.isLoginFree(freeLogin));
        assertEquals(false, conn.isLoginFree(takenLogin));

    }

    @Test
    public void getAllUsers() {
        List<User> users = conn.findAllUsers();
        System.out.println(users);
        int count = users.size();
        assertEquals(conn.getUsersCount(), count);

    }
}
