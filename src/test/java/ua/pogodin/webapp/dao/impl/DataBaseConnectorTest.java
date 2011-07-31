package ua.pogodin.webapp.dao.impl;

import org.junit.*;
import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author elias
 */
public class DataBaseConnectorTest {
    private static JdbcConnection conn;
    private User user;
    private Bus bus;
    private BusApplication busApp;

    @BeforeClass
    public static void setUpClass() throws Exception {
        conn = new DataBaseConnector();

        DbExecutor.execSqlFile("droptables.sql");
        DbExecutor.execSqlFile("createtables.sql");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        DbExecutor.execSqlFile("droptables.sql");
    }

    @Before
    public void setUp() {
        user = conn.createUser(new User("testuser", "testpass", "the name", true, new Bus()));
        bus = conn.createBus(new Bus(40, 140, true));
        busApp = conn.createBusApp(new BusApplication(30, 40, false, user.getId()));
    }

    @After
    public void tearDown() {
        DbExecutor.execSqlFile("deletetablesdata.sql");
    }

    @Test
    public void userShouldBeGettableById() {
        User user = conn.getUserById(this.user.getId());
        assertUsersEqual(this.user, user);
    }

    @Test
    public void userShouldBeGettableByLogin() {
        User user = conn.getUserByLogin(this.user.getLogin());
        assertUsersEqual(this.user, user);
    }

    @Test
    public void loginShouldBeFreeAfterUserDelete() {
        conn.deleteUserByLogin(user.getLogin());

        boolean actual = conn.isLoginFree(user.getLogin());
        assertEquals(true, actual);
    }

    @Test
    public void dispatcherShouldBeDispather() {
        boolean isDispatcher = conn.isDispatcher("testuser");
        assertTrue(isDispatcher);
    }

    @Test
    public void busShouldBeFoundableById() {
        Bus bus = conn.getBusById(this.bus.getId());
        assertBussesEqual(this.bus, bus);
    }

    @Test
    public void loginShouldNotBeFreeForExistingUser() {
        assertFalse(conn.isLoginFree("testuser"));
    }

    @Test
    public void loginShouldBeFreeForNonExistingUser() {
        assertTrue(conn.isLoginFree("some_non-existing_user"));
    }

    @Test
    public void allUsersShouldBeFoundable() {
        List<User> users = conn.findAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void allBusAppsShouldBeFoundable() {
        List<BusApplication> busApps = conn.findAllBusApplications();
        assertNotNull(busApps);
        assertEquals(1, busApps.size());
    }

    private void assertUsersEqual(User expectedUser, User user) {
        assertNotNull(user);
        assertEquals(expectedUser.getId(), user.getId());
        assertEquals(expectedUser.getLogin(), user.getLogin());
        assertEquals(expectedUser.getPassword(), user.getPassword());
        assertEquals(expectedUser.getName(), user.getName());
        assertEquals(expectedUser.getBus(), user.getBus());
    }

    private void assertBussesEqual(Bus expectedBus, Bus bus) {
        assertNotNull(bus);
        assertEquals(expectedBus.getId(), bus.getId());
        assertEquals(expectedBus.getBusload(), bus.getBusload());
        assertEquals(expectedBus.getMaxSpeed(), bus.getMaxSpeed());
        assertEquals(expectedBus.isWorkingOrder(), bus.isWorkingOrder());
    }
}
