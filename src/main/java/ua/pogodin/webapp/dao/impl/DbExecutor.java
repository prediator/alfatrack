package ua.pogodin.webapp.dao.impl;

import ua.pogodin.webapp.util.AppException;
import ua.pogodin.webapp.util.Properties;

import java.io.InputStreamReader;
import java.sql.*;

public class DbExecutor {
    public static final String URL = Properties.get(DataBaseConnector.PROPNAME_URL);
    public static final String USERNAME = Properties.get(DataBaseConnector.PROPNAME_USERNAME);
    public static final String PASSWORD = Properties.get(DataBaseConnector.PROPNAME_PASSWORD);

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;

    public static DbExecutor execSelect(String sql, String... params) throws AppException {
        DbExecutor executor = new DbExecutor();

        getConnection(executor);
        prepareStatementAndSetStringParams(executor, sql, params);

        try {
            executor.rs = executor.preparedStatement.executeQuery();
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't execute query: " + sql, e);
        }

        return executor;
    }

    public static void execUpdate(String sql, String... values) {
        DbExecutor executor = new DbExecutor();

        getConnection(executor);
        prepareStatementAndSetStringParams(executor, sql, values);

        try {
            executor.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("Can't execute update: " + sql, e);
        } finally {
            close(executor);
        }
    }

    private static void getConnection(DbExecutor executor) {
        try {
            executor.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't obtain connection to DB", e);
        }
    }

    private static void prepareStatementAndSetStringParams(DbExecutor executor, String sql, String[] params) {
        try {
            executor.preparedStatement = executor.connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                executor.preparedStatement.setString(i+1, params[i]);
            }
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't create prepared statement for query: " + sql, e);
        }
    }

    public static void close(DbExecutor executor) {
        if (executor != null) {
            if (executor.preparedStatement != null) {
                try {
                    executor.preparedStatement.close();
                } catch (SQLException ignored) {
                }
            }
            if (executor.connection != null) {
                try {
                    executor.connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public ResultSet rs() {
        return rs;
    }

    public static void execSqlFile(String sqlFilePath) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, true);
            scriptRunner.runScript(new InputStreamReader(DbExecutor.class.getResourceAsStream("/sql/" + sqlFilePath)));
        } catch (Exception e) {
            throw new AppException("Can't execute sql file /sql/" + sqlFilePath, e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}
