package ua.pogodin.webapp.util;

/**
 * Manipulations with database
 */
import ua.pogodin.webapp.dao.impl.DbExecutor;

public class DbUtils {
    private enum Param {
        CREATE_TABLES("ct", "/createtables.sql"),
        DELETE_TABLES_DATA("dt", "/deletetablesdata.sql"),
        DROP_TABLES("drop", "/droptables.sql");

        private String param;
        private String sqlFilePath;

        private Param(String param, String sqlFilePath) {
            this.param = param;
            this.sqlFilePath = sqlFilePath;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            pleaseSetParam();
        }

        String param = args[0].toLowerCase();

        for (Param paramEnum : Param.values()) {
            if (paramEnum.param.equals(param)) {
                DbExecutor.execSqlFile(paramEnum.sqlFilePath);
                return;
            }
        }
        
        pleaseSetParam();
    }

    private static void pleaseSetParam() {
        System.out.print("Please set parameter one of the following:");
        for (Param param : Param.values()) {
            System.out.println(" " + param.param);
        }
    }
}
