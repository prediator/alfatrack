package ua.pogodin.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<User>();
        users.add(new User("Ann"));
        users.add(new User("Boris"));
        users.add(new User("Clay"));
        users.add(new User("Dick"));

        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/users.jsp").forward(req, resp);
    }

    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    
    private List<User> getAllUsers(){
    	List<User> res = new ArrayList<User>();
    	
    	return res;
    }
}
