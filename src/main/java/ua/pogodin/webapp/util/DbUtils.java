package ua.pogodin.webapp.util;

/**
 * Manipulations with database
 */
import ua.pogodin.webapp.dao.impl.DbExecutor;

public class DbUtils {
    private enum Param {
        CREATE_TABLES("ct", "createtables.sql"),
        DELETE_TABLES_DATA("dt", "deletetablesdata.sql"),
        DROP_TABLES("drop", "droptables.sql");

        private String command;
        private String sqlFilePath;

        private Param(String command, String sqlFilePath) {
            this.command = command;
            this.sqlFilePath = sqlFilePath;
        }

        static Param byCommand(String command) {
            for (Param paramEnum : Param.values()) {
                if (paramEnum.command.equals(command)) {
                    return paramEnum;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            pleaseSetParam();
        }

        String command = args[0].toLowerCase();
        Param param = Param.byCommand(command);

        if (param != null ) {
            exec(param);
        } else {
            pleaseSetParam();
        }
    }

    public static void exec(Param param) {
        DbExecutor.execSqlFile(param.sqlFilePath);
    }

    private static void pleaseSetParam() {
        System.out.print("Please set parameter one of the following:");
        for (Param param : Param.values()) {
            System.out.println(" " + param.command);
        }
    }
}
