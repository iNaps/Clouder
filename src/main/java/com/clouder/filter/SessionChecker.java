package com.clouder.filter;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "session", urlPatterns = {"/cabinet.jsp"})
public final class SessionChecker implements Filter {
    private static final Logger LOGGER = Logger.getLogger(SessionChecker.class.getName());
    public void doFilter(ServletRequest reqs, ServletResponse resps, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) reqs;
        HttpServletResponse resp = (HttpServletResponse) resps;
        if (req.getSession().getAttribute("user") == null) {
            LOGGER.info("Unauthorized client was rejected");
            resp.sendRedirect("/index.jsp");
        } else {
            req.getRequestDispatcher("/cabinet.jsp").forward(reqs, resps);
        }
    }
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void destroy() {}
}