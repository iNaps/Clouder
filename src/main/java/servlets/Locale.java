package servlets;

import database.mysql.Connector;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/locale")
public class Locale extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loc = req.getParameter("loc");
        if (loc != null) {
            session.setAttribute("language", loc);
            LOGGER.info("Localization set");
        } else {
            session.setAttribute("language", "default");
        }
        String ref = req.getHeader("referer");
        String res = ref.replaceAll("http://localhost:8080", "");
        resp.sendRedirect(res);
    }
}
