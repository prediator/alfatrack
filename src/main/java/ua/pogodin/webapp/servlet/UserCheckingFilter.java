package ua.pogodin.webapp.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserCheckingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
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
