package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import java.io.IOException;
import java.net.HttpRetryException;
import java.util.List;

public class Register extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User userAdded = new User();
		req.getSession(false).setAttribute("userAdded", userAdded);
		forward("/WEB-INF/jsp/register.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pass1 = (String) req.getParameter("pass1");
		String pass2 = (String) req.getParameter("pass2");
		String login = (String) req.getParameter("login");
		String name = (String) req.getParameter("name");
		
		

		boolean loginTaken = ((login == null) || !dbConnector.isLoginFree(login));
		boolean isPassWrong = ((pass1 == null) || (pass2 == null) || !pass1.equals(pass2));
		boolean notNameInputted = (name == null);
		
		User user = (User)req.getSession().getAttribute("userAdded");
		user.setName((name==null)?"":name);
		user.setLogin(login==null?"":login);
		

		req.setAttribute("loginTaken", loginTaken ? 1 : 0);
		req.setAttribute("isPassWrong", isPassWrong ? 1 : 0);
		req.setAttribute("notNameInputted", notNameInputted ? 1 : 0);

		if(loginTaken || name == null || isPassWrong){
			forward("/WEB-INF/jsp/register.jsp", req, resp);
		}else{
			fillUp(req, resp, login, pass1, name);
		}
	}

	protected void fillUp(HttpServletRequest req, HttpServletResponse resp, String login, String pass, String name)
			throws IOException {
		String isDisp = (String) req.getAttribute("isDispatcher");
		boolean isDispatcher = isDisp.equals("dispatcher");

		User addedUser = new User(login, pass, name, isDispatcher, new Bus());

		if (isDispatcher) {
			dbConnector.createUser(addedUser);
			resp.sendRedirect("dispatcher");
		} else {
			req.getSession(false).setAttribute("addedUser", addedUser);
			resp.sendRedirect("busCreate");
		}

	}
}
