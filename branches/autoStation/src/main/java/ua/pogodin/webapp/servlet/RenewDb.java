package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.util.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RenewDb extends BaseServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DbUtils.exec(DbUtils.Param.DROP_TABLES);
        DbUtils.exec(DbUtils.Param.CREATE_TABLES);
        DbUtils.exec(DbUtils.Param.FILL_TABLES_DATA);

        resp.sendRedirect("login");
    }
}
