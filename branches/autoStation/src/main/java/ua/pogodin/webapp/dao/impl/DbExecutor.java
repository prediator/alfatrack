package ua.pogodin.webapp.dao.impl;

import ua.pogodin.webapp.util.AppException;
import ua.pogodin.webapp.util.Properties;

import java.io.InputStreamReader;
import java.sql.*;

class DbExecutor {
    public static final String URL = Properties.get(DataBaseConnector.PROPNAME_URL);
    public static final String USERNAME = Properties.get(DataBaseConnector.PROPNAME_USERNAME);
    public static final String PASSWORD = Properties.get(DataBaseConnector.PROPNAME_PASSWORD);

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet rs;

    public static DbExecutor execSelect(String sql, String... params) throws AppException {
        DbExecutor executor = new DbExecutor();

        try {
            executor.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't obtain connection to DB", e);
        }

        try {
            executor.preparedStatement = executor.connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                executor.preparedStatement.setString(i+1, params[i]);
            }
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't create prepared statement for query: " + sql, e);
        }

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

        try {
            executor.connection = DriverManager.getConnection(Properties.get(DataBaseConnector.PROPNAME_URL),
                    Properties.get(DataBaseConnector.PROPNAME_USERNAME), Properties.get(DataBaseConnector.PROPNAME_PASSWORD));
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't obtain connection to DB", e);
        }

        try {
            executor.preparedStatement = executor.connection.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                executor.preparedStatement.setString(i+1, values[i]);
            }
        } catch (SQLException e) {
            close(executor);
            throw new AppException("Can't create prepared statement for query: " + sql, e);
        }

        try {
            executor.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("Can't execute update: " + sql, e);
        } finally {
            close(executor);
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
            scriptRunner.runScript(new InputStreamReader(DbExecutor.class.getResourceAsStream(sqlFilePath)));
        } catch (Exception e) {
            throw new AppException("Can't execute sql file " + sqlFilePath, e);
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
