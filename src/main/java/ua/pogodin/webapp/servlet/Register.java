package ua.pogodin.webapp.servlet;

import ua.pogodin.webapp.dao.JdbcConnection;
import ua.pogodin.webapp.dao.impl.DataBaseConnector;
import ua.pogodin.webapp.domain.Bus;
import ua.pogodin.webapp.domain.BusApplication;
import ua.pogodin.webapp.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Register extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward("/WEB-INF/jsp/register.jsp",req,resp);
	}
	
	//TODO: make it fucking sheet

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
    	
	}
    protected void fillUp(){
    	
    }
}
