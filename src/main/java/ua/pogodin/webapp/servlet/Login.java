package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.domain.User;
import ua.pogodin.webapp.util.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currSession = req.getSession(true);

        User user = (User) currSession.getAttribute("user");
        if (user == null) {
            forward("/WEB-INF/jsp/login.jsp", req, resp);
        } else {
            redirectToHomePage(resp, user);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        HttpSession currSession = req.getSession(true);

        User user;
        try {
            user = dataBaseConnector.getUserByLoginAndPass(login, pass);
        } catch (AppException e) {
            req.setAttribute("wrong_credentials", true);
            resp.sendRedirect("login");
            return;
        }

        currSession.setAttribute("user", user);
        redirectToHomePage(resp, user);
    }

    private void redirectToHomePage(HttpServletResponse resp, User user) throws IOException {
        if (user.isDispatcher()) {
            resp.sendRedirect("dispatcher");
        } else {
            resp.sendRedirect("driver");
        }
    }
}
