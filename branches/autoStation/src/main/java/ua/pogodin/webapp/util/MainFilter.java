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
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		if (!isRequestToLoginPage(req)) {
			HttpSession session = ((HttpServletRequest) req).getSession(false);

			if (session == null || session.getAttribute("user") == null) {
				((HttpServletResponse) resp).sendRedirect("login");
				return;
			} else {
				req.setAttribute("user", session.getAttribute("user"));
			}
		}

		chain.doFilter(req, resp);
	}

	private boolean isRequestToLoginPage(ServletRequest req) {
		return ((HttpServletRequest) req).getServletPath().contains("login");
	}

	@Override
	public void destroy() {
	}

}
