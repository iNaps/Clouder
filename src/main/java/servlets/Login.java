package servlets;

import database.Connector;
import database.LoginChecker;
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
        session.setAttribute("username", null);
        session.setAttribute("id", null);
        LOGGER.info("User logged out");
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();
        int id = LoginChecker.check(login, pass);
        if (id > 0) {
            session.setAttribute("username", login);
            session.setAttribute("id", id);
            LOGGER.info("User signed in");
            resp.sendRedirect("/cabinet.jsp");
        } else {
            out.print("false");
        }
    }
}