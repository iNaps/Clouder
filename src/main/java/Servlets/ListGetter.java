package Servlets;

import database.ListMaker;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/list")
public class ListGetter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        int id = (Integer) req.getSession().getAttribute("id");
        String list = ListMaker.get(id);
        out.print(list);
    }
}

