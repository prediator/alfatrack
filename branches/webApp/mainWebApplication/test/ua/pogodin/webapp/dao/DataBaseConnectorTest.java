/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pogodin.webapp.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.domain.bus.Bus;

/**
 *
 * @author elias
 */
public class DataBaseConnectorTest {
    
    DataBaseConnector con;
    public DataBaseConnectorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, 
    InstantiationException, IllegalAccessException {
        con = new DataBaseConnector();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of closeConnection method, of class DataBaseConnector.
     */
    @Test
    public void testCloseConnection() throws Exception {
        System.out.println("closeConnection");
        con.closeConnection();
        
    }

    /**
     * Test of isDispatcher method, of class DataBaseConnector.
     */
    @Test
    public void testIsDispatcher() throws Exception {
        System.out.println("isDispatcher");
        String login = "admin";
        boolean expResult = true;
        boolean result = con.isDispatcher(login);
        assertEquals(expResult, result);
    }

    /**
     * Test of getParam method, of class DataBaseConnector.
     */
    @Test
    public void testGetParam() throws Exception {
        System.out.println("getParam");
        String param = "name";
        String login = "driver";
        String expResult = "vasya";
        String result = con.getParam(param, login);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccess method, of class DataBaseConnector.
     */
    @Test
    public void testGetAccess() throws Exception {
        System.out.println("getAccess");
        String login = "driver";
        String pass = "driver";
        boolean expResult = true;
        boolean result = con.isAccess(login, pass);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserById method, of class DataBaseConnector.
     */
    @Test
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        int id = 1;
        User expResult = new User(id, "admin", "admin", "kolya", true, new Bus());
        User result = con.getUserById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBusById method, of class DataBaseConnector.
     */
    @Test
    public void testGetBusById() throws Exception {
        System.out.println("getBusById");
        int id = 1;
        Bus expResult = new Bus(id, 45, 100, true);
        Bus result = con.getBusById(id);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testGetUserByLogin() throws Exception {
        System.out.println("getUserById");
        String login = "admin";
        User expResult = new User(1, login, "admin", "kolya", true, new Bus());
        User result = con.getUserByLogin(login);
        assertEquals(expResult, result);
    }

    /**
     * Test of createUser method, of class DataBaseConnector.
    
      */
     
    
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        User user = new User(con.usersCount() + 1, "a", "b", "c", true, new Bus());
        con.closeConnection();
        con = new DataBaseConnector();
        con.createUser(user);
        User tested = con.getUserByLogin(user.getLogin());
        assertEquals(user, tested);
        
        con.deleteUserByLogin(user.getLogin());
    }

    /**
     * Test of isLoginFree method, of class DataBaseConnector.
     */
    @Test
    public void testIsLoginFree() throws Exception {
        System.out.println("isLoginFree");
        String login = "admin";
        boolean expResult = false;
        boolean result = con.isLoginFree(login);
        assertEquals(expResult, result);
    }

    /**
     * Test of usersCount method, of class DataBaseConnector.
     */
    @Test
    public void testUsersCount() throws Exception {
        System.out.println("usersCount");
        int expResult = 2;
        int result = con.usersCount();
        assertEquals(expResult, result);
    }
}
