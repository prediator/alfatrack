package ua.pogodin.webapp.dao.impl;

import org.junit.Before;
import org.junit.Test;
import ua.pogodin.webapp.util.Properties;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Precondition: no tables in DB
 */
public class ScriptRunnerTest {
    public static final String URL = Properties.get(DataBaseConnector.PROPNAME_URL);
    public static final String USERNAME = Properties.get(DataBaseConnector.PROPNAME_USERNAME);
    public static final String PASSWORD = Properties.get(DataBaseConnector.PROPNAME_PASSWORD);
    public static final String SCHEMA = URL.substring(URL.lastIndexOf("/") + 1);

    private ScriptRunner scriptRunner;

    @Before
    public void setUp() throws Exception {
        Connection connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        scriptRunner = new ScriptRunner(connection, false, true);
    }

    @Test
    public void scriptShouldBeRunned() throws Exception {
        scriptRunner.runScript(new InputStreamReader(getClass().getResourceAsStream("/createdb.sql")));

        assertTableCreated("users");
        assertTableCreated("busses");
        assertTableCreated("bus_application");

        scriptRunner.runScript(new InputStreamReader(getClass().getResourceAsStream("/droptables.sql")));

        assertTableDropped("users");
        assertTableDropped("busses");
        assertTableDropped("bus_application");
    }

    private void assertTableCreated(String tableName) throws Exception {
        assertTableCount(tableName, 1);
    }

    private void assertTableDropped(String tableName) throws Exception {
        assertTableCount(tableName, 0);
    }

    private void assertTableCount(String tableName, int tableCount) throws Exception {
        DbExecutor executor = DbExecutor.execSelect("SELECT COUNT(*) " +
                "FROM information_schema.tables " +
                "WHERE table_schema = ? " +
                "AND table_name = ?", SCHEMA, tableName);

        assertTrue(executor.rs().next());
        assertEquals(tableCount, executor.rs().getInt(1));

        DbExecutor.close(executor);
    }
}
