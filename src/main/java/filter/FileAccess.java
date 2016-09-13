package filter;
import database.Connector;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebFilter(filterName = "access", urlPatterns = {"/userfiles/*"})
public class FileAccess implements Filter {
    public void doFilter(ServletRequest reqs, ServletResponse resps, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) reqs;
        HttpServletResponse resp = (HttpServletResponse) resps;
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Integer id = (Integer) req.getSession().getAttribute("id");
        if (id == null) {
            out.write("No access");
        } else {
//            resp.sendRedirect("/test.jsp");
            String[] urlPath = req.getRequestURL().toString().split("http://localhost:8080/");
            try {
                String sql = "SELECT filepath FROM files where id=\"" + id + '"';
                ResultSet set = Connector.getSet(sql);
                while (set.next()) {
                    if (!set.getString("filepath").equals(urlPath[1])) {
                        out.write("Logged, but not your file");
                    } else {
                        out.write("Ok");
                    }
                }
            } catch (SQLException exc) {
                out.write(exc.toString());
                Logger.getLogger(exc.getMessage());
            }
        }
    }
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void destroy() {}
}