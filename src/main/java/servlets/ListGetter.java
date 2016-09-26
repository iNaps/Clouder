package servlets;

import database.ListMaker;
import database.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/list")
public class ListGetter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        String list = ListMaker.get(user.getId());
        out.print(list);
    }
}

