package servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/header")
public class Header extends HttpServlet {
    @Override
    public void service(ServletRequest reqs, ServletResponse ress) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) reqs;
        HttpServletResponse resp = (HttpServletResponse) ress;
        String login = (String)req.getSession().getAttribute("username");
        getServletContext().getRequestDispatcher(login != null ? "/header.auth.jsp" : "/header.unauth.jsp").include(req, resp);
    }
}