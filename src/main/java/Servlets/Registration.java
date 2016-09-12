package Servlets;

import database.Registrator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        Registrator regr = Registrator.getInst();
        if (regr.reg(login, req.getParameter("password"), req.getParameter("email"))) {
            HttpSession ss = req.getSession();
            ss.setAttribute("username", login);
            ss.setAttribute("id", regr.getId());
            resp.sendRedirect("/cabinet.jsp");
        }
    }
}
