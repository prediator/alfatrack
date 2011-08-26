package ua.pogodin.webapp.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.domain.User;

/**
 * @author elias
 */
public class BaseServlet extends HttpServlet {

	@EJB
    public DbConnection dbJPAConnector;
    
/*    @Override
    public void init() throws ServletException {
        if (dbJPAConnector == null) {
            dbJPAConnector = new HiberJPADao();
        }
    }*/

    protected void forward(String jspPath, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(jspPath).forward(req, resp);
    }

    protected User getUser(HttpServletRequest req) {
        return (User) req.getAttribute("user");
    }
}
