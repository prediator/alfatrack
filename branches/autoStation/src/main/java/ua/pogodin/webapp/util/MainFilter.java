package ua.pogodin.webapp.util;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.pogodin.webapp.domain.User;

public class MainFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)req).getSession();
		HttpServletResponse hresp = (HttpServletResponse)resp;
		try{
			if(session.getAttribute("user") == null){
				hresp.sendRedirect("login");
			}else{
				User user = (User)session.getAttribute("user");
				if(!user.isDispatcher()){
					hresp.sendRedirect("driver");
				}
			}
			
		}catch (Exception e) {
		
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	
}
