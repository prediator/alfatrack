package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.impl.DataBaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    protected static DataBaseConnector dataBaseConnector;

    @Override
    public void init() throws ServletException {
        dataBaseConnector = new DataBaseConnector();
    }

    protected void forward(String jspPath, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(jspPath).forward(req, resp);
    }
}
