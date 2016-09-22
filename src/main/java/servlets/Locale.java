package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/locale")
public class Locale extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loc = req.getParameter("loc");
        session.setAttribute("language", loc);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
//        resp.sendRedirect("/index.jsp");
    }
}
