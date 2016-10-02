package servlets;

import database.mysql.User;
import database.mysql.UserFactory;
import database.mysql.Connector;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("user", null);
        LOGGER.info("User logged out");
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = UserFactory.getInst().read(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            LOGGER.info("User signed in");
            resp.sendRedirect("/cabinet.jsp");
        } else {
            req.setAttribute("error", true);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
