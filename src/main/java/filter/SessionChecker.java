package filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "session", urlPatterns = {"/cabinet.jsp"})
public class SessionChecker implements Filter {
    public void doFilter(ServletRequest reqs, ServletResponse resps, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) reqs;
        HttpServletResponse resp = (HttpServletResponse) resps;
        if (req.getSession().getAttribute("username") == null) {
            resp.sendRedirect("/index.jsp");
        } else {
            req.getRequestDispatcher("/cabinet.jsp").forward(reqs, resps);
        }
    }
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void destroy() {}
}