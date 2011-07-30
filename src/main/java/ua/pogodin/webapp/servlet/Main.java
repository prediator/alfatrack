package ua.pogodin.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import ua.pogodin.webapp.domain.*;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html>The main servlet is up and running</html>");
        writer.flush();
    }
    
    private List<User> getAllUsers(){
    	List<User> res = new ArrayList<User>();
    	
    	return res;
    }
}
