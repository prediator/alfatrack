package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author elias
 */
public class BaseServlet extends HttpServlet {

    protected static JdbcConnection dbConnector;

    /**
     * Yes, I know that the initialization is not thread safe. So as all the application.
     * @throws ServletException if something goes wrong
     */
    @Override
    public void init() throws ServletException {
        if (dbConnector == null) {
            dbConnector = new DataBaseConnector();
        }
    }

    protected void forward(String jspPath, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(jspPath).forward(req, resp);
    }

    protected User getUser(HttpServletRequest req) {
        return (User) req.getAttribute("user");
    }
}
